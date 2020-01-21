/*
package cn.zealon.book.system.org.dao;

import cn.zealon.book.common.base.BaseMapper;
import cn.zealon.book.system.org.entity.OrgPermission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface OrgPermissionMapper extends BaseMapper<OrgPermission> {

    List<String> getPermissionsByUser(String userid);

    */
/**
     * 按父分类查询最后一条子分类记录 编号（folderid）
     * @param parentFolderid
     * @return
     *//*

    String selectLastFolderidByParent(@Param("parentFolderid") String parentFolderid);

    */
/**
     * 根据用户ID查询权限 同时返回权限范围
     * 注意：这里只会保存该用户对的应角色 有权限范围的权限 （*好好读读*）
     * @param userid
     * @return permission:权限; rangeType:权限范围
     *//*

    @Select("select d.permission " +
            "from org_role_permission a " +
            "inner join org_role b on a.role_id=b.id " +
            "inner join org_user_role c on c.roleId=b.id " +
            "inner join org_permission d on a.permission_id=d.id " +
            "where c.userId=#{userid}")
    List<OrgPermission> selectPermissionRangeByUserid(String userid);

    @Select("select d.id " +
            "from org_role_permission a " +
            "inner join org_role b on a.role_id=b.id " +
            "inner join org_user_role c on c.roleId=b.id " +
            "inner join org_permission d on a.permission_id=d.id " +
            "where b.id=#{roleid}")
    List<OrgPermission> selectByRoleid(String roleid);

}
*/
