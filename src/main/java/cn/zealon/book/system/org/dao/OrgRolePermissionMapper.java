package cn.zealon.book.system.org.dao;

import cn.zealon.book.system.org.entity.OrgRolePermission;
import org.apache.ibatis.annotations.Param;

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
}
