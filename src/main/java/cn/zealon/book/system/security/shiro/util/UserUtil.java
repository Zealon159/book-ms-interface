package cn.zealon.book.system.security.shiro.util;

import cn.zealon.book.system.org.vo.OrgUserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
public class UserUtil {
	/**
	 * 获取当前登录用户对象
	 * @return
	 */
	public static OrgUserVO getCurrentOrgUser(){
		OrgUserVO user = null;
		try {
			Subject subject = SecurityUtils.getSubject();
			if (subject != null) {
				user = (OrgUserVO) subject.getPrincipal();
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 获取当前登录用户ID
	 * @return
	 */
	public static String getCurrentUserId(){
		String userId = "";
		Subject subject = SecurityUtils.getSubject();
		if(subject!=null && subject.getPrincipal() != null){
			userId = ((OrgUserVO)subject.getPrincipal()).getUserId();
		}
		return userId;
	}
	
	/**
	 * 获取当前登录用户名称
	 * @return
	 */
	public static String getCurrentUserName(){
		String userName = "";
		Subject subject = SecurityUtils.getSubject();
		if(subject!=null){
			userName = ((OrgUserVO)subject.getPrincipal()).getUserName();
		}
		return userName;
	}

	/**
	 * 获取当前session
	 * @return
	 */
	public static String getCurrentSessionId(){
		return SecurityUtils.getSubject().getSession().getId().toString();
	}

}
