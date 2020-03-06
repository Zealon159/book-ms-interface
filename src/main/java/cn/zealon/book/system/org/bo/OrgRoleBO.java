package cn.zealon.book.system.org.bo;

import java.util.List;

/**
 * 角色
 * @author: tangyl
 * @since: 2020/3/4
 */
public class OrgRoleBO {

    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序
     */
    private Integer sortNumber;

    private Integer[] permissions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }

    public Integer[] getPermissions() {
        return permissions;
    }

    public void setPermissions(Integer[] permissions) {
        this.permissions = permissions;
    }
}
