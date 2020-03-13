package cn.zealon.book.system.org.dao;

import cn.zealon.book.system.org.entity.OrgRolePermission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 角色权限关联
 * @author: tangyl
 * @since: 2020/2/6
 */
public interface OrgRolePermissionMapper {

    int batchInsert(List<OrgRolePermission> list);

    int deleteByRoleId(@Param("roleId") Integer roleId);

    List<OrgRolePermission> selectByRoleId(@Param("roleId") Integer roleId);

    /**
     * 查询所有使用权限的角色名称
     * @param permissionId
     * @return
     */
    @Select(" select name from org_role where id in (select role_id from org_role_permission where permission_id = #{permissionId}) ")
    List<String> selectRoleNamesByPermission(@Param("permissionId") Integer permissionId);
}
