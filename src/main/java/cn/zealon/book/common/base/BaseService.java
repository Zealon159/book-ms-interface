package cn.zealon.book.common.base;

import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.PageVO;
import cn.zealon.book.common.result.Result;

/**
 * Service 层基础接口，其他Service 接口 请继承该接口
 */
public interface BaseService<T> {

    /**
     * 持久化
     * @param model
     * @return
     */
	Result create(T model);

    /**
     * 通过主鍵刪除
     * @param id
     * @return
     */
    Result deleteById(Integer id);

    /**
     * 更新
     * @param model
     * @return
     */
    Result update(T model);

    /**
     * 通过ID查找
     * @param id
     * @return
     */
    Result findById(Integer id);

    /**
     * 分页查询
     * @param params
     * @return
     */
    PageVO<T> getPageList(Params params);
}
