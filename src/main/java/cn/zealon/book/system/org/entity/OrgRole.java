package cn.zealon.book.system.org.entity;

import cn.zealon.book.common.base.BaseEntity;

/**
 * 用戶角色
 */
public class OrgRole extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private int id;

    private String roleName;

    private String roleDesc;

    private Integer sortNumber;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

}