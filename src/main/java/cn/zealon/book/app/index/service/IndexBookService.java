package cn.zealon.book.app.index.service;

import cn.zealon.book.app.index.dao.IndexBookMapper;
import cn.zealon.book.app.index.vo.IndexBookVO;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 主页服务
 * @author: zealon
 * @since: 2020/3/18
 */
@Service
public class IndexBookService {

    @Autowired
    private IndexBookMapper indexBookMapper;

    /**
     * 查询最新书籍列表
     * @param limit 查询数量
     * @return
     */
    public Result getNewBooks(Integer limit){
        List<IndexBookVO> booklist = this.indexBookMapper.selectNewBooks(limit);
        return ResultUtil.successAndNoMsg(booklist);
    }
}
