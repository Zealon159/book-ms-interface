package cn.zealon.book.system.org.dao;

import cn.zealon.book.common.base.BaseMapper;
import cn.zealon.book.common.result.SelectVO;
import cn.zealon.book.system.org.entity.OrgRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: tangyl
 * @since: 2020/2/1
 */
public interface OrgRoleMapper extends BaseMapper<OrgRole> {

    @Select("select id,name text from org_role order by sort_number asc")
    List<SelectVO> getRoleOptions();

}
