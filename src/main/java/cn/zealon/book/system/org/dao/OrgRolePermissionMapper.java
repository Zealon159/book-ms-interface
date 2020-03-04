package cn.zealon.book.system.org.dao;

import cn.zealon.book.system.org.entity.OrgRolePermission;

import java.util.List;

/**
 * 角色权限关联
 * @author: tangyl
 * @since: 2020/2/6
 */
public interface OrgRolePermissionMapper {

    int batchInsert(List<OrgRolePermission> list);

    int deleteByRoleId(String userId);

    List<OrgRolePermission> selectByRoleId(String userId);
}
