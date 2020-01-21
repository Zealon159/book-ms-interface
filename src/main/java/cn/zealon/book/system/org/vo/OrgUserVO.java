package cn.zealon.book.system.org.vo;

import java.util.Map;

/**
 * @author: zealon
 * @since: 2019/10/30
 */
public class OrgUserVO {

    private Long id;

    private String userid;

    private String userName;

    private String phoneNumber;

    private String post;

    private Long deptId;

    private Integer userType;

    private Integer enterpriseId;

    private Integer sortNumber;

    private Long roleId;

    private String headUrl;

    /**
     * 这个字段是为了 在登录成功后再去查询一遍权限信息
     * 获取到权限和权限范围的键值对 为数据级别权限提供数据
     */
    private Map<String,Boolean> orgPermission;

    public Map<String, Boolean> getOrgPermission() {
        return orgPermission;
    }

    public void setOrgPermission(Map<String, Boolean> orgPermission) {
        this.orgPermission = orgPermission;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Integer getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(Integer sortNumber) {
		this.sortNumber = sortNumber;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

}
