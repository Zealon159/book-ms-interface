package cn.zealon.book.system.security.service.impl;

import cn.zealon.book.system.org.service.OrgUserService;
import cn.zealon.book.system.org.vo.OrgUserVO;
import cn.zealon.book.system.security.service.LoginService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统登录服务类
 * @author zealon
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private OrgUserService orgUserService;

	/**
	 * 登录程序
	 */
	@Override
	public Map<String, Object> doLogin(String loginName, String pwd) {

		Map<String, Object> map = new HashMap<>();
		boolean success = false;
		String msg = "";
		String errorCode = "200";
		OrgUserVO userVO = null;

		if (StringUtils.isBlank(loginName) || StringUtils.isBlank(pwd) ){
			msg = "用户名、密码不能为空！";
			errorCode = "400";
		} else {
			// 得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
			Subject subject = SecurityUtils.getSubject();

			if (subject.isAuthenticated()) {
				success = true;
			} else {
				UsernamePasswordToken token = new UsernamePasswordToken(loginName, pwd);
				try {
					// 4、登录，即身份验证
					subject.login(token);
					if (subject.isAuthenticated()) {
						success = true;
					}
				} catch (UnknownAccountException e) {
					msg = "找不到账户！";
					errorCode = e.toString();
				} catch (IncorrectCredentialsException e) {
					msg = "密码不匹配！";
					errorCode = e.toString();
				} catch (LockedAccountException e) {
					msg = "账户被锁定！";
					errorCode = e.toString();
				} catch (AuthenticationException e) {
					msg = "身份验证失败！";
					errorCode = e.toString();
				}
			}

			if (success) {
				msg = "登录成功！";
				// 获取用户展示信息
				userVO = (OrgUserVO) this.orgUserService.getUserInfo().getData();
			}
		}

		map.put("success", success);
		map.put("msg", msg);
		map.put("code", errorCode);
		map.put("user",userVO);
		return map;
	}

	/**
	 * 登出系统
	 */
	public void doLogout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
	}
}
