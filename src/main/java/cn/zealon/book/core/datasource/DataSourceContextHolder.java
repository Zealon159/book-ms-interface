package cn.zealon.book.core.datasource;

public class DataSourceContextHolder {
	
	private static ThreadLocal<DataSourceEnum> contextHolder = new ThreadLocal<DataSourceEnum>();

    /**
     * @desction: 提供给AOP去设置当前的线程的数据源的信息
     * @param: DataSourceEnum
     * @return: void
     */
    public static void setTargetDataSource(DataSourceEnum targetDataSource) {
    	contextHolder.set(targetDataSource);
    }

    /**
     * @desction: 提供给AbstractRoutingDataSource的实现类，通过key选择数据源
     * @return: DataSourceEnum
     */
    public static DataSourceEnum getTargetDataSource() {
        return contextHolder.get();
    }

    /**
     * @desction: 使用默认的数据源
     */
    public static void resetDefaultDataSource() {
    	contextHolder.remove();
    }
}
