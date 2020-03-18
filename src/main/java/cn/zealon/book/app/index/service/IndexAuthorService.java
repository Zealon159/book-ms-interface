package cn.zealon.book.app.index.service;

import cn.zealon.book.app.index.dao.IndexAuthorMapper;
import cn.zealon.book.app.index.vo.IndexAuthorVO;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 主页作者服务
 * @author: zealon
 * @since: 2020/3/18
 */
@Service
public class IndexAuthorService {

    @Autowired
    private IndexAuthorMapper indexAuthorMapper;

    /**
     * 获取作者排名
     * @param limit
     * @return
     */
    public Result getRankingAuthors(Integer limit){
        List<IndexAuthorVO> authors = this.indexAuthorMapper.selectTopAuthors(limit);
        return ResultUtil.successAndNoMsg(authors);
    }
}
