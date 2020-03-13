package cn.zealon.book.system.org.dao;

import cn.zealon.book.system.org.entity.OrgUser;
import cn.zealon.book.system.org.vo.OrgUserVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户 DAO
 */
public interface OrgUserMapper {

    int deleteByPrimaryKey(String userId);

    int insert(OrgUser orgUser);

    int updateByPrimaryKey(OrgUser orgUser);

    OrgUser selectByUserId(String userId);

    List<OrgUserVO> findPageWithResult(@Param("keyword") String keyword,
                                       @Param("deptId") Integer deptId);

    Integer findPageWithCount(@Param("keyword") String keyword,
                              @Param("deptId") Integer deptId);

    @Select("select count(1) num from org_user where dept_id=#{deptId}")
    Integer findCountByDept(@Param("deptId") Integer deptId);

}