package cn.zealon.book.system.org.dao;

import cn.zealon.book.common.base.BaseMapper;
import cn.zealon.book.common.result.SelectVO;
import cn.zealon.book.system.org.entity.OrgDept;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrgDeptMapper extends BaseMapper<OrgDept> {

    @Select("select id,name text from org_dept order by sort_number")
    List<SelectVO> getDeptSelect();
}