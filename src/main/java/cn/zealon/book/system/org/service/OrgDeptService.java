package cn.zealon.book.system.org.service;

import cn.zealon.book.common.base.AbstractBaseService;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.SelectVO;
import cn.zealon.book.common.result.util.ResultUtil;
import cn.zealon.book.system.org.dao.OrgDeptMapper;
import cn.zealon.book.system.org.dao.OrgUserMapper;
import cn.zealon.book.system.org.entity.OrgDept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 用户部门服务
 * @author zealon
 * @date 2019年3月1日
 */
@Service
public class OrgDeptService extends AbstractBaseService<OrgDept> {

    @Autowired
    private OrgDeptMapper orgDeptMapper;

    @Autowired
    private OrgUserMapper orgUserMapper;

    /**
     * 获取下拉数据源
     * @return
     */
    public Result getDeptSelect(){
        List<SelectVO> selectVOS = this.orgDeptMapper.getDeptSelect();
        return ResultUtil.successAndNoMsg(selectVOS);
    }

    @Override
    public Result deleteById(Integer id) {
        Integer userCount = orgUserMapper.findCountByDept(id);
        if (userCount > 0) {
            return ResultUtil.verificationFailed().buildMessage("删除失败，该部门下还有" + userCount + "个用户，请先移动用户至其它部门！");
        }
        return super.deleteById(id);
    }
}
