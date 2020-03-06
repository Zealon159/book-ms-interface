package cn.zealon.book.system.security.controller;

import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.enums.HttpCodeEnum;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.util.ResultUtil;
import cn.zealon.book.system.security.service.impl.LoginServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 系统登录控制器
 */
@CrossOrigin
@RestController
public class LoginController {
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginServiceImpl loginService;

	@PostMapping("/doLogin")
	public Map<String,Object> doLogin(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String,Object> params) throws UnsupportedEncodingException{
		SavedRequest savedRequest=WebUtils.getSavedRequest(request);
		Params p = Params.build(params).cleanEmpty();
		String userId = p.getString("userId");
		String pwd = p.getString("pwd");
		String remenber = p.getString("remenber");
		if (StringUtils.isBlank(remenber)){
			remenber = "1";
		}

		Map<String,Object> map = loginService.doLogin(userId, pwd);
		if((Boolean)map.get("success")==true){
			String url = null;
			if(savedRequest!=null) {
				url = savedRequest.getRequestUrl();
			}
			if(savedRequest==null||url.equals("/") || url.equals("/favicon.ico")){
				url = "system";
			}

			map.put("url", url);
			//登录成功
			//创建Cookie    
	        Cookie nameCookie=new Cookie("name",URLEncoder.encode(userId,"utf-8"));
	        Cookie pswCookie=new Cookie("psw",pwd);
	            
	        //设置Cookie的父路径    
	        nameCookie.setPath(request.getContextPath()+"/");    
	        pswCookie.setPath(request.getContextPath()+"/");    
	        logger.debug(remenber+"--------");
			//保存Cookie的时间长度，单位为秒
	        if(remenber.equals("1")){
	        	nameCookie.setMaxAge(7*24*60*60);
	            pswCookie.setMaxAge(7*24*60*60);
	        }else{
	        	nameCookie.setMaxAge(0);    
	            pswCookie.setMaxAge(0); 
	        }
	        //加入Cookie到响应头    
	        response.addCookie(nameCookie);    
	        response.addCookie(pswCookie);    
		}
		return map;
	}
	
	@GetMapping("/logout")
	public Result logout(){
		loginService.doLogout();
		return ResultUtil.success();
	}

	@GetMapping("/login")
	public Result login(){
		return ResultUtil.custom(HttpCodeEnum.USERNAME_OR_PASSWORD_ERR);
	}

}
