package cn.zealon.book.common.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 公共基类
 */
public abstract class BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	/** 主键ID */
	protected Integer id;
	/** 创建人 */
	protected String creater;
	/** 创建时间 */
	protected Date createTime;
	/** 修改人 */
	protected String updater;
	/** 修改时间 */
	protected Date updateTime;
    
	public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdater() {
		return updater;
	}
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
    
}
