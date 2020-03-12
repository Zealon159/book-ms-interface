package cn.zealon.book.system.security.controller;

import cn.zealon.book.system.org.service.OrgUserService;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 安全处理
 * @author: tangyl
 * @since: 2019/10/30
 */
@CrossOrigin
@RestController
public class SecurityController {

    @Autowired
    private OrgUserService orgUserService;

    @GetMapping("/401")
    public ResponseEntity sessionTimeout() {
        System.out.println("401");
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/403")
    public Result forbidden(){
        return ResultUtil.forbidden();
    }

    @GetMapping("/404")
    public Result notFound(){
        return ResultUtil.notFound();
    }

    @GetMapping("/user-info")
    public Result getUserInfo(){
        return this.orgUserService.getUserInfo();
    }
}
