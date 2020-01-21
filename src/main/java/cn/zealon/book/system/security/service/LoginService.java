package cn.zealon.book.system.security.service;

import java.util.Map;

public interface LoginService {
	Map<String, Object> doLogin(String uid, String pwd);
}
