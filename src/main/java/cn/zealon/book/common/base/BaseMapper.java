package cn.zealon.book.common.base;

import java.util.List;

/**
 * MyBatis Mapper基础接口，其他Mapper接口 请继承该接口
 */
public interface BaseMapper<T>{
	/** 新增记录 */
	Integer insert(T record);
	/** 修改记录 */
	Integer updateByPrimaryKey(T record);
	/** 按id删除记录 */
	Integer deleteByPrimaryKey(Integer id);
	/** 按id查询实体 */
	T selectById(Integer id);
	/** 查询总数 */
	Integer selectAllCount();
	/** 查询全部集合 */
	List<T> selectAll();
}
