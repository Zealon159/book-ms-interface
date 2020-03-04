package cn.zealon.book.system.org.entity;

import java.io.Serializable;

/**
 * 用戶角色映射
 */
public class OrgUserRole implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String userId;

	/**
	 * 角色
	 */
	private Integer roleId;

	public OrgUserRole(){}

	public OrgUserRole(String userId, Integer roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}