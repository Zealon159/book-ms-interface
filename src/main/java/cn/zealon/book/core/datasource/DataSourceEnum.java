package cn.zealon.book.core.datasource;

/**
 * 数据源定义
 * desc：枚举内参数，需要按数据库类型进行赋值（目前只支持sqlserver、mysql两种）
 */
public enum DataSourceEnum {
	/**
	 * 默认数据源
	 */
	MASTER("mysql");

    private String datasource;

    DataSourceEnum( final String datasource){
        this.datasource=datasource;
    }

    public String getDataSource() {
        return datasource;
    }
}
