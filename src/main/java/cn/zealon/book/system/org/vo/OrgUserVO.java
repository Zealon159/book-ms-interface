package cn.zealon.book.system.org.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author: zealon
 * @since: 2019/10/30
 */
public class OrgUserVO  implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 所属部门
     */
    private Integer deptId;

    private String deptName;

    /**
     * 中文名
     */
    private String userName;

    /**
     * 排序
     */
    private Integer sortNumber;

    /**
     * 冻结状态
     */
    private Boolean freezeStatus;

    /**
     * 联系电话
     */
    private String phoneNumber;

    private List<String> roles;

    private String headImgUrl;

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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }
}
