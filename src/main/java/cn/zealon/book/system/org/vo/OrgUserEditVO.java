package cn.zealon.book.system.org.vo;

/**
 * @author: tangyl
 * @since: 2020/2/6
 */
public class OrgUserEditVO {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 所属部门
     */
    private Integer deptId;

    /**
     * 密码
     */
    private String userPwd;

    /**
     * 中文名
     */
    private String userName;

    /**
     * 联系电话
     */
    private String phoneNumber;

    /**
     * 排序
     */
    private Integer sortNumber;

    private Boolean freezeStatus;

    private String headImgUrl;

    /**
     * 用户角色
     */
    private Integer[] roles;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
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

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    public Boolean getFreezeStatus() {
        return freezeStatus;
    }

    public void setFreezeStatus(Boolean freezeStatus) {
        this.freezeStatus = freezeStatus;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Integer[] getRoles() {
        return roles;
    }

    public void setRoles(Integer[] roles) {
        this.roles = roles;
    }
}
