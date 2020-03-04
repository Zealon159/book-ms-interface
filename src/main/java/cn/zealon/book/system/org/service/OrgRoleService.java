package cn.zealon.book.system.org.service;

import cn.zealon.book.common.base.AbstractBaseService;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.SelectVO;
import cn.zealon.book.common.result.util.ResultUtil;
import cn.zealon.book.system.org.dao.OrgRoleMapper;
import cn.zealon.book.system.org.entity.OrgRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zealon
 * @since: 2020/2/1
 */
@Service
public class OrgRoleService extends AbstractBaseService<OrgRole> {

    @Autowired
    private OrgRoleMapper orgRoleMapper;

    public Result getRoleOptions(){
        List<SelectVO> roleOptions = this.orgRoleMapper.getRoleOptions();
        return ResultUtil.successAndNoMsg().buildData(roleOptions);
    }
}
