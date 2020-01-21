package cn.zealon.book.system.org.dao;

import cn.zealon.book.system.org.entity.OrgUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户 DAO
 */
public interface OrgUserMapper {

    int deleteByPrimaryKey(String userId);

    int insert(OrgUser orgUser);

    int updateByPrimaryKey(OrgUser orgUser);

    OrgUser selectByUserId(String userId);

    List<OrgUser> findPageWithResult(@Param("keyword") String keyword,
                                     @Param("deptId") Integer deptId);

    Integer findPageWithCount(@Param("keyword") String keyword,
                              @Param("deptId") Integer deptId);

}