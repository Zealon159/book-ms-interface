package cn.zealon.book.system.org.dao;

import cn.zealon.book.system.org.entity.OrgUserRole;

import java.util.List;

/**
 * 用户角色关联
 * @author: zealon
 * @since: 2020/2/4
 */
public interface OrgUserRoleMapper {

    int batchInsert(List<OrgUserRole> list);

    int deleteByUserId(String userId);

    List<OrgUserRole> selectByUserId(String userId);
}
