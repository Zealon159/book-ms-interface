package cn.zealon.book.app.user.controller;

import cn.zealon.book.common.base.BaseController;
import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.system.org.bo.OrgUserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.zealon.book.app.user.service.*;

import java.util.Map;

/**
 * 客户端用户操作接口
 * @author: tangyl
 * @since: 2020/3/12
 */
@RestController
@RequestMapping("user")
public class ClientUserController extends BaseController {

    @Autowired
    private ClientUserService clientUserService;

    @PutMapping("/update")
    public Result updateUserInfo(@RequestBody OrgUserBO record){
        return this.clientUserService.updateUserInfo(record);
    }

    @PutMapping("/update-pwd")
    public Result updateUserPwd(@RequestBody Map<String,Object> params){
        Params p = Params.build(params).cleanEmpty();
        String currentPwd = p.getString("currentPwd");
        String pass = p.getString("pass");
        return this.clientUserService.updateUserPwd(currentPwd, pass);
    }
}
