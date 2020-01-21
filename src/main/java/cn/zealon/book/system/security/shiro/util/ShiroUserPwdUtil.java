package cn.zealon.book.system.security.shiro.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * shiro的用户密码加密工具
 * @author zealon
 * @date 2018年2月22日
 */
public class ShiroUserPwdUtil {
	
	/**
	 * 加密用户密码
	 * @param userId
	 * @param userPwd
	 * @return 加密后的密码
	 */
	public static String generateEncryptPwd(String userId, String userPwd) {
		//加密方式
		String hashAlgorithmName = "MD5";
		//盐值
		ByteSource credentialsSalt = ByteSource.Util.bytes(userId);
		//加密密码
		Object pwd = userPwd;
		//加密次数
		int hashIterations = 3; 
		
		String encryptPwd = new SimpleHash(hashAlgorithmName, pwd, credentialsSalt, hashIterations).toHex();
		return encryptPwd;
	}
}