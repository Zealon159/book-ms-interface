package cn.zealon.book.common.base;

import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.PageVO;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.util.ResultUtil;
import cn.zealon.book.system.security.shiro.util.UserUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
public abstract class AbstractBaseService<T> implements BaseService<T> {

	protected final Logger LOGGER = LoggerFactory.getLogger(AbstractBaseService.class);

    @Autowired
    protected BaseMapper<T> mapper;

    @Override
    public Result create(T record) {
    	Date date = new Date();
    	BaseEntity r = (BaseEntity)record;
    	r.setCreateTime(date);
    	r.setUpdateTime(date);
    	r.setCreater(UserUtil.getCurrentUserId());
    	r.setUpdater(UserUtil.getCurrentUserId());
    	try {
			if (mapper.insert(record) > 0) {
				return ResultUtil.success();
			} else {
				return ResultUtil.fail();
			}
		} catch (Exception ex){
			LOGGER.error("!!!持久化数据失败：{}，Data:{}",ex.getMessage(), record.toString());
			return ResultUtil.fail();
		}
    }

    @Override
    public Result update(T record) {
    	Date date = new Date();
    	BaseEntity r = (BaseEntity)record;
		r.setCreateTime(date);
		r.setUpdateTime(date);
    	r.setUpdater(UserUtil.getCurrentUserId());
		try {
			if (mapper.updateByPrimaryKey(record) > 0) {
				return ResultUtil.success();
			} else {
				return ResultUtil.fail();
			}
		} catch (Exception ex){
			LOGGER.error("!!!更新数据失败：{}，Data:{}",ex.getMessage(), record.toString());
			return ResultUtil.fail();
		}
    }

    @Override
    public Result deleteById(Integer id) {
		try {
			if (mapper.deleteByPrimaryKey(id) > 0) {
				return ResultUtil.success();
			} else {
				return ResultUtil.fail();
			}
		} catch (Exception ex){
			LOGGER.error("!!!删除数据失败：{}，ID:{}",ex.getMessage(), id);
			return ResultUtil.fail();
		}
    }

    @Override
    public Result findById(Integer id) {
		return ResultUtil.successAndNoMsg(mapper.selectById(id));
	}

	@Override
	public PageVO<T> getPageList(Params params) {
		Integer page = params.getInt("page");
		Integer limit = params.getInt("limit");
		PageHelper.startPage(page, limit);
		Page<T> pageList = (Page<T>) this.mapper.selectAll();
		return new PageVO<>(pageList.getTotal(),200,"",pageList);
	}
}
