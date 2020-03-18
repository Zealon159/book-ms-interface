package cn.zealon.book.app.index.controller;

import cn.zealon.book.app.index.service.IndexAuthorService;
import cn.zealon.book.app.index.service.IndexBookService;
import cn.zealon.book.common.base.BaseController;
import cn.zealon.book.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 主页接口
 * @author: zealon
 * @since: 2020/3/18
 */
@RestController
@RequestMapping("index")
public class IndexController extends BaseController {

    @Autowired
    private IndexBookService indexBookService;

    @Autowired
    private IndexAuthorService indexAuthorService;

    /**
     * 最新图书列表
     * @param limit
     * @return
     */
    @GetMapping("/get-new-books")
    public Result getNewBooks(Integer limit){
        return this.indexBookService.getNewBooks(limit);
    }

    /**
     * 作者排行列表
     * @param limit
     * @return
     */
    @GetMapping("/get-ranking-authors")
    public Result getRankingAuthors(Integer limit){
        return this.indexAuthorService.getRankingAuthors(limit);
    }
}
