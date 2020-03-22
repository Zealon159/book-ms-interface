package cn.zealon.book.system.org.service;

import cn.zealon.book.common.Const;
import cn.zealon.book.common.base.AbstractBaseService;
import cn.zealon.book.common.config.SystemPropertiesConfig;
import cn.zealon.book.common.domain.Cascader;
import cn.zealon.book.common.domain.RouterMeta;
import cn.zealon.book.common.domain.Router;
import cn.zealon.book.common.result.*;
import cn.zealon.book.common.result.util.ResultUtil;
import cn.zealon.book.system.org.bo.OrgPermissionBO;
import cn.zealon.book.system.org.dao.OrgPermissionMapper;
import cn.zealon.book.system.org.dao.OrgRolePermissionMapper;
import cn.zealon.book.system.org.entity.OrgPermission;
import cn.zealon.book.system.org.vo.MenuVO;
import cn.zealon.book.system.org.vo.OrgPermissionEditVO;
import cn.zealon.book.system.security.shiro.util.UserUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 权限管理
 */
@Service
public class OrgPermissionService extends AbstractBaseService<OrgPermission> {

    private final Logger LOGGER = LoggerFactory.getLogger(OrgPermissionService.class);

    @Autowired
    private OrgPermissionMapper orgPermissionMapper;

    @Autowired
    private OrgRolePermissionMapper orgRolePermissionMapper;

    @Autowired
    private SystemPropertiesConfig systemPropertiesConfig;

    @Override
    @Transactional
    public Result create(OrgPermission model) {
        try {
            Date now = new Date();
            model.setCreater(UserUtil.getCurrentUserId());
            model.setUpdater(UserUtil.getCurrentUserId());
            model.setCreateTime(now);
            model.setUpdateTime(now);
            this.orgPermissionMapper.insert(model);

            // 更新父级菜单状态
            OrgPermission parent = new OrgPermission();
            parent.setId(model.getParentId());
            parent.setHasChildren(true);
            this.orgPermissionMapper.updateByPrimaryKey(parent);
            return ResultUtil.success();
        } catch (Exception ex){
            LOGGER.error("创建菜单失败：{}",ex.getMessage());
            return ResultUtil.fail();
        }
    }

    @Transactional
    public Result update(OrgPermissionBO record) {
        if (this.systemPropertiesConfig.getDeleteSwitch()) {
            if (record.getId() <= 44) {
                return ResultUtil.verificationFailed().buildMessage(Const.TIP_CONTENT);
            }
        }
        try {
            OrgPermission permission = new OrgPermission();
            // 处理上级ID
            String parentId = record.getParentId().get(record.getParentId().size() - 1);
            OrgPermission dbPermission = this.orgPermissionMapper.selectById(record.getId());
            if (dbPermission.getId().toString().equals(parentId)) {
                return ResultUtil.verificationFailed().buildMessage("操作失败了 ┭┮﹏┭┮ ，所属上级不能选择自己哦！");
            }

            Integer pid = Integer.parseInt(parentId);
            permission.setParentId(pid);
            BeanUtils.copyProperties(record, permission);
            this.orgPermissionMapper.updateByPrimaryKey(permission);

            // 处理新父级菜单
            OrgPermission parent = new OrgPermission();
            parent.setId(pid);
            parent.setHasChildren(true);
            this.orgPermissionMapper.updateByPrimaryKey(parent);

            // 处理原父级菜单
            Integer childrenCount = this.orgPermissionMapper.selectChildrenCount(dbPermission.getParentId());
            if (childrenCount == 0) {
                OrgPermission oldParent = new OrgPermission();
                oldParent.setId(dbPermission.getParentId());
                oldParent.setHasChildren(false);
                this.orgPermissionMapper.updateByPrimaryKey(oldParent);
            }
            return ResultUtil.success();
        } catch (Exception ex){
            LOGGER.error("更新菜单失败：{}",ex.getMessage());
            return ResultUtil.fail();
        }
    }

    @Transactional
    public Result deleteById(Integer parentId,Integer id) {
        if (this.systemPropertiesConfig.getDeleteSwitch()) {
            if (id <= 44) {
                return ResultUtil.verificationFailed().buildMessage(Const.TIP_CONTENT);
            }
        }
        // 验证是否有角色在使用
        List<String> roleNames = this.orgRolePermissionMapper.selectRoleNamesByPermission(id);
        if (roleNames.size() > 0) {
            String roles = StringUtils.join(roleNames.toArray(), ",");
            return ResultUtil.verificationFailed().buildMessage("删除失败！当前角色["+roles+"]正在使用该权限！");
        }

        // 验证是否有子菜单
        Integer childrenCount = this.orgPermissionMapper.selectChildrenCount(id);
        if (childrenCount > 0) {
            return ResultUtil.verificationFailed().buildMessage("删除失败！该记录下还有子权限哦，请先删除子权限！");
        }

        // 删除操作
        this.orgPermissionMapper.deleteByPrimaryKey(id);

        // 更新父级菜单状态
        Integer parentChildrenCount = this.orgPermissionMapper.selectChildrenCount(parentId);
        if (parentChildrenCount == 0) {
            OrgPermission parent = new OrgPermission();
            parent.setId(parentId);
            parent.setHasChildren(false);
            this.orgPermissionMapper.updateByPrimaryKey(parent);
        }
        return ResultUtil.success();
    }

    /**
     * 获取编辑详情接口
     * @param id
     * @return
     */
    public Result getEditDetails(Integer id){
        OrgPermission permission = this.mapper.selectById(id);
        if (permission == null) {
            return ResultUtil.notFound();
        }
        OrgPermissionEditVO vo = new OrgPermissionEditVO();
        BeanUtils.copyProperties(permission,vo);
        List<String> parentIds = this.getParentIds(permission.getParentId());
        vo.setParentId(parentIds);
        return ResultUtil.successAndNoMsg(vo);
    }

    /**
     * 获取权限列表
     * @param parentId  父级ID
     * @return
     */
    public Result getList(Integer parentId){
        List<OrgPermission> orgPermissions = this.orgPermissionMapper.selectAll(parentId , null);
        return ResultUtil.successAndNoMsg().buildData(orgPermissions);
    }

    /**
     * 获取权限树
     * @return
     */
    public Result getPermissionTree(){
        List<TreeDataVO> tree = this.getTreeByParentId(0);
        return ResultUtil.successAndNoMsg(tree);
    }

    /**
     * 获取用户菜单JSON
     * @param userId
     * @return
     */
    public Result getUserMenus(String userId){
        List<Integer> permissionIds = this.orgPermissionMapper.selectPermissionIdsByUserId(userId);
        if (permissionIds.size() == 0) {
            return ResultUtil.successAndNoMsg(new ArrayList<>());
        }

        // 查询用户菜单
        List<MenuVO> menus = this.orgPermissionMapper.selectUserMenusByParentId(0, permissionIds);
        for (int i = 0; i < menus.size(); i++) {
            MenuVO menu = menus.get(i);
            List<MenuVO> subMenus = this.orgPermissionMapper.selectUserMenusByParentId(menu.getId(), permissionIds);
            menu.setChildren(subMenus);
            menus.set(i,menu);
        }
        return ResultUtil.successAndNoMsg(menus);
    }

    /**
     * 获取 Cascader 组件选项数据源
     * @return
     */
    public Result getParentCascaderOptions(){
        List<Cascader> data = new ArrayList<>();
        Cascader root = new Cascader("0","根目录");
        // 一级目录
        List<OrgPermission> orgPermissions = this.orgPermissionMapper.selectAll(0 ,null);
        List<Cascader> cascaders = new ArrayList<>(orgPermissions.size());
        for (int i = 0; i < orgPermissions.size(); i++) {
            OrgPermission permission = orgPermissions.get(i);
            Cascader cascader = new Cascader(permission.getId().toString(),permission.getName());
            if (permission.getHasChildren()) {
                // 二级菜单
                List<OrgPermission> subPermissions = this.orgPermissionMapper.selectAll(permission.getId() ,"menu");
                List<Cascader> subCascaders = new ArrayList<>(subPermissions.size());
                for (int j = 0; j < subPermissions.size(); j++) {
                    OrgPermission subPermission = subPermissions.get(j);
                    Cascader subCascader = new Cascader(subPermission.getId().toString(),subPermission.getName());
                    subCascaders.add(subCascader);
                }
                if (subCascaders.size() > 0) {
                    cascader.setChildren(subCascaders);
                }
            }
            cascaders.add(cascader);
        }
        if (cascaders.size() > 0) {
            root.setChildren(cascaders);
        }
        data.add(root);
        return ResultUtil.successAndNoMsg(data);
    }

    /**
     * 获取用户路由
     * @return
     */
    public Result getUserRouters(String userId){
        List<Router> routers = new ArrayList<>();
        List<Integer> permissionIds = this.orgPermissionMapper.selectPermissionIdsByUserId(userId);
        if (permissionIds.size() == 0) {
            return ResultUtil.successAndNoMsg(new ArrayList<>());
        }

        // 获取用户全部菜单
        List<OrgPermission> permissions = this.orgPermissionMapper.selectUserPermissions(permissionIds);
        Map<Integer,OrgPermission> permissionMap = permissions.stream().collect(Collectors.toMap(OrgPermission::getId, Function.identity(), (k1, k2) -> k2));

        // 计算路由
        for (int i = 0; i < permissions.size(); i++) {
            OrgPermission permission = permissions.get(i);
            if (permission.getParentId() != 0 && StringUtils.isNotBlank(permission.getPagePath())) {
                // 计算元数据
                List<RouterMeta> meta = this.getRouterMeta(permission,permissionMap);
                Router router = new Router(permission.getResourceUrl(),permission.getName(),permission.getPagePath(),false,meta);
                routers.add(router);
            }
        }
        return ResultUtil.successAndNoMsg(routers);
    }

    /**
     * 获取路由元数据
     * @param permission
     * @param permissionMap
     * @return
     */
    private List<RouterMeta> getRouterMeta(OrgPermission permission,Map<Integer,OrgPermission> permissionMap){
        List<RouterMeta> metas = new ArrayList<>();
        int i = 0;
        while (permission.getParentId() != 0){
            String path = "";
            if (i > 0) {
                path = permission.getResourceUrl();
            }
            RouterMeta meta = new RouterMeta(permission.getName(), path);
            metas.add(meta);
            permission = permissionMap.get(permission.getParentId());
            i++;
        }
        // 处理显示顺序
        Collections.reverse(metas);
        return metas;
    }

    /**
     * 获取父级ids
     * @param parentId
     * @return
     */
    private List<String> getParentIds(Integer parentId){
        List<String> parentIds = new ArrayList<>();
        List<String> ids = new ArrayList<>();
        OrgPermission parentPermission = this.mapper.selectById(parentId);
        while (parentPermission != null) {
            ids.add(parentPermission.getId().toString());
            parentPermission = this.mapper.selectById(parentPermission.getParentId());
        }
        ids.add("0");
        for (int i = ids.size() - 1 ; i >= 0 ; i--) {
            parentIds.add(ids.get(i));
        }
        return parentIds;
    }

    /**
     * 递归获取菜单树
     * @param parentId
     * @return
     */
    private List<TreeDataVO> getTreeByParentId(Integer parentId){
        List<TreeDataVO> trees;
        List<OrgPermission> permissions = this.orgPermissionMapper.selectAll(parentId, null);
        trees = new ArrayList<>(permissions.size());
        for (int i = 0; i < permissions.size(); i++) {
            TreeDataVO vo = new TreeDataVO();
            OrgPermission permission = permissions.get(i);
            vo.setId(permission.getId());
            vo.setLabel(permission.getName());
            if (permission.getHasChildren()) {
                vo.setChildren(this.getTreeByParentId(permission.getId()));
            }
            trees.add(vo);
        }
        return trees;
    }
}