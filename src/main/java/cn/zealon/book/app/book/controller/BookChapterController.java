package cn.zealon.book.app.book.controller;

import cn.zealon.book.app.book.entity.BookChapter;
import cn.zealon.book.app.book.service.BookChapterService;
import cn.zealon.book.common.base.BaseController;
import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.PageVO;
import cn.zealon.book.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 章节接口
 * @author: zealon
 * @since: 2020/3/18
 */
@RestController
@RequestMapping("book-chapter")
public class BookChapterController extends BaseController {

    @Autowired
    private BookChapterService bookChapterService;

    @PostMapping("/create")
    public Result create(@RequestBody BookChapter record){
        return bookChapterService.create(record);
    }

    @PutMapping("/update")
    public Result update(@RequestBody BookChapter record){
        return bookChapterService.update(record);
    }

    @DeleteMapping("/delete")
    public Result delete(Integer id){
        return bookChapterService.deleteById(id);
    }

    @GetMapping("/get-list")
    public PageVO<BookChapter> findByPage(@RequestParam Map<String,Object> params){
        Params p = Params.build(params).cleanEmpty();
        return bookChapterService.getPageList(p);
    }

    /**
     * 详情
     */
    @GetMapping("/details")
    public Result details(Integer id){
        return bookChapterService.findById(id);
    }

    /**
     * 获取阅读章节信息（当前章节内容、上一章ID、下一章ID）
     * @param id
     * @return
     */
    @GetMapping("/read")
    public Result getReadChapterInfo(Integer id){
        return this.bookChapterService.getReadChapterInfo(id);
    }
}
