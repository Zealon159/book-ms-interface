package cn.zealon.book.system.org.dao;

import cn.zealon.book.system.org.entity.OrgUserRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    @Select("select user_id from org_user_role where role_id=#{roleId}")
    List<String> selectUserIdsByRoleId(@Param("roleId") Integer roleId);
}
