package cn.zealon.book.system.org.service;

import cn.zealon.book.common.Const;
import cn.zealon.book.common.base.AbstractBaseService;
import cn.zealon.book.common.config.SystemPropertiesConfig;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.SelectVO;
import cn.zealon.book.common.result.util.ResultUtil;
import cn.zealon.book.system.org.bo.OrgRoleBO;
import cn.zealon.book.system.org.dao.OrgRoleMapper;
import cn.zealon.book.system.org.dao.OrgRolePermissionMapper;
import cn.zealon.book.system.org.dao.OrgUserRoleMapper;
import cn.zealon.book.system.org.entity.OrgRole;
import cn.zealon.book.system.org.entity.OrgRolePermission;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色管理
 * @author: zealon
 * @since: 2020/2/1
 */
@Service
public class OrgRoleService extends AbstractBaseService<OrgRole> {

    private final Logger LOGGER = LoggerFactory.getLogger(OrgRoleService.class);

    @Autowired
    private OrgRoleMapper orgRoleMapper;

    @Autowired
    private OrgUserRoleMapper orgUserRoleMapper;

    @Autowired
    private OrgRolePermissionMapper orgRolePermissionMapper;

    @Autowired
    private SystemPropertiesConfig systemPropertiesConfig;

    @Transactional
    public Result create(OrgRoleBO record) {
        try {
            // 新增角色
            OrgRole role = new OrgRole();
            BeanUtils.copyProperties(record, role);
            super.create(role);
            // 处理角色权限
            this.saveRolePermissions(record.getPermissions(),role.getId());
        } catch (Exception ex){
            LOGGER.error("创建角色失败：{}",ex.getMessage());
            return ResultUtil.fail().buildMessage("角色保存失败了！");
        }
        return ResultUtil.success();
    }

    @Transactional
    public Result update(OrgRoleBO record) {
        if (this.systemPropertiesConfig.getDeleteSwitch()) {
            if (record.getId() <= 4) {
                return ResultUtil.verificationFailed().buildMessage(Const.TIP_CONTENT);
            }
        }
        try {
            OrgRole role = new OrgRole();
            BeanUtils.copyProperties(record, role);
            super.update(role);
            // 删除角色权限
            this.orgRolePermissionMapper.deleteByRoleId(record.getId());
            // 处理角色权限
            this.saveRolePermissions(record.getPermissions(), record.getId());
        } catch (Exception ex){
            LOGGER.error("更新角色失败：{}",ex.getMessage());
            return ResultUtil.fail().buildMessage("角色更新失败了！");
        }
        return ResultUtil.success();
    }

    @Override
    @Transactional
    public Result deleteById(Integer id) {
        if (this.systemPropertiesConfig.getDeleteSwitch()) {
            if (id <= 4) {
                return ResultUtil.verificationFailed().buildMessage(Const.TIP_CONTENT);
            }
        }
        List<String> uids = this.orgUserRoleMapper.selectUserIdsByRoleId(id);
        if (uids.size() > 0) {
            String uid = StringUtils.join(uids.toArray(), ",");
            return ResultUtil.verificationFailed().buildMessage("当前用户[" + uid + "]正在使用该角色，不能乱删哦~");
        }
        try {
            // 删除角色
            this.orgRoleMapper.deleteByPrimaryKey(id);
            // 删除角色权限
            this.orgRolePermissionMapper.deleteByRoleId(id);
        } catch (Exception ex){
            LOGGER.error("删除角色失败：{}",ex.getMessage());
            return ResultUtil.fail().buildMessage("删除角色失败了！");
        }
        return ResultUtil.success().buildMessage("删除成功！");
    }

    /**
     * 获取角色下拉选择数据源
     * @return
     */
    public Result getRoleOptions(){
        List<SelectVO> roleOptions = this.orgRoleMapper.getRoleOptions();
        return ResultUtil.successAndNoMsg().buildData(roleOptions);
    }

    /**
     * 获取角色权限IDs
     * @param roleId
     * @return
     */
    public Result getRolePermissoionIds(Integer roleId){
        List<Integer> permissionIds = new ArrayList<>();
        List<OrgRolePermission> list = this.orgRolePermissionMapper.selectByRoleId(roleId);
        for (int i = 0; i < list.size(); i++) {
            permissionIds.add(list.get(i).getPermissionId());
        }
        return ResultUtil.successAndNoMsg().buildData(permissionIds);
    }

    /**
     * 保存角色权限
     * @param permissionIds
     * @param roleId
     */
    private void saveRolePermissions(Integer[] permissionIds,Integer roleId){
        if (permissionIds != null && permissionIds.length > 0) {
            List<OrgRolePermission> permissions = new ArrayList<>();
            for (int i = 0; i < permissionIds.length; i++) {
                OrgRolePermission rolePermission = new OrgRolePermission(permissionIds[i],roleId);
                permissions.add(rolePermission);
            }
            this.orgRolePermissionMapper.batchInsert(permissions);
        }
    }
}