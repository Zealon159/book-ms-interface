package cn.zealon.book.system.security.controller;

import cn.zealon.book.system.org.entity.OrgUser;
import cn.zealon.book.system.org.vo.OrgUserVO;
import cn.zealon.book.system.security.shiro.util.UserUtil;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.util.ResultUtil;
import org.springframework.beans.BeanUtils;
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
        OrgUser user = UserUtil.getCurrentOrgUser();
        if (user == null){
            return ResultUtil.forbidden();
        }
        OrgUserVO vo = new OrgUserVO();
        BeanUtils.copyProperties(user, vo);
        return ResultUtil.success(vo);
    }
}
