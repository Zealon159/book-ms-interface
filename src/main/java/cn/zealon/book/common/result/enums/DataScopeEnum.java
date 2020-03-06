package cn.zealon.book.common.result.enums;

/**
 * 
 * 数据权限范围
 * -----------------------------------------------------------------
 * DATA_SCOPE_ALL("所有数据"),
 * DATA_SCOPE_COMPANY_AND_CHILD("所在公司及以下数据"),
 * DATA_SCOPE_COMPANY("所在公司数据"),
 * DATA_SCOPE_OFFICE_AND_CHILD("所在部门及以下数据"),
 * DATA_SCOPE_OFFICE("所在部门数据"),
 * DATA_SCOPE_SELF("仅本人数据"),
 * DATA_SCOPE_CUSTOM("按明细设置");
 * -----------------------------------------------------------------
 */
public enum DataScopeEnum {

    /**
     * 所有数据
     */
    DATA_SCOPE_ALL("所有数据"),
    /**
     * 所在公司及以下数据
     */
    DATA_SCOPE_COMPANY_AND_CHILD("所在公司及以下数据"),
    /**
     * 所在公司数据
     */
    DATA_SCOPE_COMPANY("所在公司数据"),
    /**
     * 所在部门及以下数据
     */
    DATA_SCOPE_OFFICE_AND_CHILD("所在部门及以下数据"),
    /**
     * 所在部门数据
     */
    DATA_SCOPE_OFFICE("所在部门数据"),
    /**
     * 仅本人数据
     */
    DATA_SCOPE_SELF("仅本人数据"),
    /**
     * 按明细设置
     */
    DATA_SCOPE_CUSTOM("按明细设置");

    private final String value;
    DataScopeEnum(final String value){
        this.value=value;
    }
    
    /**
     * 传入name，返回对应value
     * @return Returns the value.
     */
    public String getValue(){
        return value;
    }

    /**
     * 传入value，返回对应name
     * @param name 中文名
     * @return Returns the name.
     */
    public static DataScopeEnum getNameByValue(String name){
        for (DataScopeEnum scopeEnum:DataScopeEnum.values()){
           if (scopeEnum.getValue().equals(name)){
               return scopeEnum;
           }
        }
        return null;
    }
}