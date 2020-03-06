package cn.zealon.book.system.org.service;

import cn.zealon.book.common.base.AbstractBaseService;
import cn.zealon.book.common.result.CascaderVO;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.TreeDataVO;
import cn.zealon.book.common.result.util.ResultUtil;
import cn.zealon.book.system.org.bo.OrgPermissionBO;
import cn.zealon.book.system.org.dao.OrgPermissionMapper;
import cn.zealon.book.system.org.entity.OrgPermission;
import cn.zealon.book.system.org.vo.MenuVO;
import cn.zealon.book.system.org.vo.OrgPermissionEditVO;
import cn.zealon.book.system.security.shiro.util.UserUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 权限管理
 */
@Service
public class OrgPermissionService extends AbstractBaseService<OrgPermission> {

    private final Logger LOGGER = LoggerFactory.getLogger(OrgPermissionService.class);

    @Autowired
    private OrgPermissionMapper orgPermissionMapper;

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
        List<CascaderVO> data = new ArrayList<>();
        CascaderVO root = new CascaderVO("0","根目录");
        // 一级目录
        List<OrgPermission> orgPermissions = this.orgPermissionMapper.selectAll(0 ,null);
        List<CascaderVO> cascaders = new ArrayList<>(orgPermissions.size());
        for (int i = 0; i < orgPermissions.size(); i++) {
            OrgPermission permission = orgPermissions.get(i);
            CascaderVO cascader = new CascaderVO(permission.getId().toString(),permission.getName());
            if (permission.getHasChildren()) {
                // 二级菜单
                List<OrgPermission> subPermissions = this.orgPermissionMapper.selectAll(permission.getId() ,"menu");
                List<CascaderVO> subCascaders = new ArrayList<>(subPermissions.size());
                for (int j = 0; j < subPermissions.size(); j++) {
                    OrgPermission subPermission = subPermissions.get(j);
                    CascaderVO subCascader = new CascaderVO(subPermission.getId().toString(),subPermission.getName());
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