package cn.zealon.book.app.dictionary.entity;

import java.io.Serializable;

/**
 * 数据字典
 * @author: tangyl
 * @since: 2020/3/13
 */
public class DataDictionary implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 字典类型
     */
    private String dicType;

    /** 类型名称 */
    private String dicTypeName;

    /**
     * 字典编码
     */
    private Integer code;

    /**
     * 字典名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sortNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDicType() {
        return dicType;
    }

    public void setDicType(String dicType) {
        this.dicType = dicType;
    }

    public String getDicTypeName() {
        return dicTypeName;
    }

    public void setDicTypeName(String dicTypeName) {
        this.dicTypeName = dicTypeName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

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
