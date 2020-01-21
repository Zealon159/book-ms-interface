package cn.zealon.book.system.org.entity;

import java.io.Serializable;

/**
 * 用戶角色映射
 */
public class OrgUserRole implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int id;

    private OrgRole orgRole;

    private String userid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrgRole getOrgRole() {
		return orgRole;
	}

	public void setOrgRole(OrgRole orgRole) {
		this.orgRole = orgRole;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}