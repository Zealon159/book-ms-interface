package cn.zealon.book.app.book.controller;

import cn.zealon.book.app.book.bo.BookBO;
import cn.zealon.book.app.book.entity.Book;
import cn.zealon.book.app.book.service.BookService;
import cn.zealon.book.common.base.BaseController;
import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.PageVO;
import cn.zealon.book.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

/**
 * 图书接口
 * @author: zealon
 * @since: 2020/3/16
 */
@RestController
@RequestMapping("book")
public class BookController extends BaseController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public Result create(@RequestBody BookBO record){
        return bookService.create(record);
    }

    @PutMapping("/update")
    public Result update(@RequestBody BookBO record){
        return bookService.update(record);
    }

    @DeleteMapping("/delete")
    public Result delete(Integer id){
        return bookService.delete(id);
    }

    @GetMapping("/get-list")
    public PageVO<Book> findByPage(@RequestParam Map<String,Object> params){
        Params p = Params.build(params).cleanEmpty();
        return bookService.getPageList(p);
    }

    /**
     * 详情
     */
    @GetMapping("/details")
    public Result details(Integer id){
        return bookService.details(id);
    }

}
