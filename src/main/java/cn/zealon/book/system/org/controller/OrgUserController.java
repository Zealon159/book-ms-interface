package cn.zealon.book.system.org.controller;

import cn.zealon.book.common.base.BaseController;
import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.PageVO;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.system.org.bo.OrgUserBO;
import cn.zealon.book.system.org.entity.OrgUser;
import cn.zealon.book.system.org.service.OrgUserService;
import cn.zealon.book.system.org.vo.OrgUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * 用户接口
 * @author: zealon
 * @since: 2020/1/21
 */
@RestController
@RequestMapping("system/org/user")
public class OrgUserController extends BaseController {

    @Autowired
    private OrgUserService orgUserService;

    @PostMapping("/create")
    public Result create(@RequestBody OrgUserBO record){
        return orgUserService.create(record);
    }

    @PutMapping("/update")
    public Result update(@RequestBody OrgUserBO record){
        return orgUserService.update(record);
    }

    @PutMapping("/update-pwd")
    public Result updatePwd(@RequestBody OrgUser record){
        return orgUserService.updatePassword(record);
    }

    @DeleteMapping("/delete")
    public Result delete(String userId){
        return orgUserService.deleteByUserId(userId);
    }

    @GetMapping("/get-list")
    public PageVO<OrgUserVO> findByPage(@RequestParam Map<String,Object> params){
        Params p = Params.build(params).cleanEmpty();
        return orgUserService.getPageList(p);
    }

    /**
     * 详情
     */
    @GetMapping("/details")
    public Result details(String userId){
        return orgUserService.findByUserId(userId);
    }

    /**
     * 编辑详情
     */
    @GetMapping("/edit-details")
    public Result findEditVOByUserId(String userId){
        return this.orgUserService.findEditVOByUserId(userId);
    }
}
