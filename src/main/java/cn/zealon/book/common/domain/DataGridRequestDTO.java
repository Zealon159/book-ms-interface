package cn.zealon.book.common.domain;

import java.io.Serializable;
import java.util.Map;

/**
 * 分页查询请求参数包装类
 * @author zealon
 * 
 */
public class DataGridRequestDTO implements Serializable {

	//当前页数
	private int page;
	//每页显示数
	private int rows;
	//查询条件
	private Map<String,Object> params;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
}
