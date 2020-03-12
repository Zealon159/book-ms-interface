package cn.zealon.book.system.security.shiro;

import cn.zealon.book.system.org.dao.OrgRoleMapper;
import cn.zealon.book.system.org.entity.OrgUser;
import cn.zealon.book.system.org.service.OrgUserService;
import cn.zealon.book.system.org.vo.OrgUserVO;
import cn.zealon.book.system.security.shiro.util.ShiroUserPwdUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import java.util.List;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

	private static Logger LOGGER = LoggerFactory.getLogger(ShiroRealm.class);
	
	@Lazy
	@Autowired
	private OrgUserService userService;

	@Autowired
	private OrgRoleMapper orgRoleMapper;

	//@Autowired
	//private OrgPermissionService orgPermissionService;

	public ShiroRealm() {
        super();
    }
	
	public ShiroRealm(CacheManager cacheManager) {
        super(cacheManager);
    }
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		// 得到用户名
		String userId = (String) upToken.getPrincipal();
		// 得到密码
		String password = new String((char[]) upToken.getCredentials());
		String encrityPwd = ShiroUserPwdUtil.generateEncryptPwd(userId, password);
		Object credentials = encrityPwd;

		OrgUser user = userService.selectByUserId(userId);
		if(user == null){
			throw new UnknownAccountException("用户不存在！");
		}
		//为了实现微信登录暂做修改 如果微信用户与数据库中的用户密码一致，允许登录：user.getUserPwd().equals(password)
		if (!(user.getUserPwd().equals(encrityPwd)||user.getUserPwd().equals(password))) {
			throw new IncorrectCredentialsException("用户密码错误！");
		}
		
		if(user.getFreezeStatus()){
			throw new LockedAccountException("用户已被冻结！");
		}

		ByteSource credentialsSalt = ByteSource.Util.bytes(userId);
		// 如果身份认证验证成功，返回一个AuthenticationInfo实现；

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(getUserInfo(user), credentials, credentialsSalt, getName());
		return info;
	}

	private OrgUserVO getUserInfo(OrgUser user){
		OrgUserVO vo = new OrgUserVO();
		BeanUtils.copyProperties(user, vo);
		// 查询角色
		List<String> roleNames = this.orgRoleMapper.getUserRoleNames(user.getUserId());
		vo.setRoles(roleNames);
		return vo;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		OrgUserVO user = (OrgUserVO) principals.getPrimaryPrincipal();

		// 角色
		Set<String> roles = userService.getUserRoles(user.getUserId());
		authorizationInfo.setRoles(roles);

		// 权限
		Set<String> permissions = userService.getUserPermissions(user.getUserId());
		authorizationInfo.setStringPermissions(permissions);
		return authorizationInfo;
	}
	
	/** 设置当前用户缓存名称 */
	@Override
    protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
		OrgUserVO shiroUser = (OrgUserVO) super.getAvailablePrincipal(principals);
        return shiroUser.getUserId();
    }

	public static void main(String[] args) {
		ByteSource credentialsSalt = ByteSource.Util.bytes("zhang");
		Object pwd = "123";
		Object result = new SimpleHash("MD5", pwd, credentialsSalt, 3);
		System.out.println(result);
	}
}
