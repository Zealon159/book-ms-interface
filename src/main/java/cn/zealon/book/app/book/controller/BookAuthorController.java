package cn.zealon.book.app.book.controller;

import cn.zealon.book.app.book.bo.BookAuthorBO;
import cn.zealon.book.app.book.entity.BookAuthor;
import cn.zealon.book.app.book.service.BookAuthorService;
import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.PageVO;
import cn.zealon.book.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * 作者接口
 * @author: zealon
 * @since: 2020/3/14
 */
@RestController
@RequestMapping("book-author")
public class BookAuthorController {

    @Autowired
    private BookAuthorService bookAuthorService;

    @PostMapping("/create")
    public Result create(@RequestBody BookAuthorBO record){
        return bookAuthorService.create(record);
    }

    @PutMapping("/update")
    public Result update(@RequestBody BookAuthorBO record){
        return bookAuthorService.update(record);
    }

    @DeleteMapping("/delete")
    public Result delete(Integer id){
        return bookAuthorService.deleteById(id);
    }

    @GetMapping("/get-list")
    public PageVO<BookAuthor> findByPage(@RequestParam Map<String,Object> params){
        Params p = Params.build(params).cleanEmpty();
        return bookAuthorService.getPageList(p);
    }

    @GetMapping("/get-select-options")
    public Result getSelectOptions(String keyword){
        return this.bookAuthorService.getAuthorOptions(keyword);
    }

    /**
     * 详情
     */
    @GetMapping("/details")
    public Result details(Integer id){
        return bookAuthorService.findById(id);
    }
}
