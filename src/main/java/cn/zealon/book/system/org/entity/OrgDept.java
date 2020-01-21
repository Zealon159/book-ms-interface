package cn.zealon.book.system.org.entity;

import cn.zealon.book.common.base.BaseEntity;

/**
 * 组织实体
 * @author zealon
 * @date 2019年2月26日
 */
public class OrgDept extends BaseEntity{

    /**
     * 部门名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sortNumber;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }
}