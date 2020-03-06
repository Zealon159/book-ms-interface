package cn.zealon.book.system.org.entity;

import java.io.Serializable;

/**
 * 角色权限关联
 * @author: zealon
 * @since: 2020/2/6
 */
public class OrgRolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 权限id
     */
    private Integer permissionId;

    /**
     * 角色id
     */
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public OrgRolePermission(){}

    public OrgRolePermission(Integer permissionId, Integer roleId) {
        this.permissionId = permissionId;
        this.roleId = roleId;
    }
}
