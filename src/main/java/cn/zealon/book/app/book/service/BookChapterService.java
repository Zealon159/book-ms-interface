package cn.zealon.book.app.book.service;

import cn.zealon.book.app.book.dao.BookChapterMapper;
import cn.zealon.book.app.book.entity.BookChapter;
import cn.zealon.book.common.base.AbstractBaseService;
import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.PageVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 章节服务
 * @author: zealon
 * @since: 2020/3/18
 */
@Service
public class BookChapterService extends AbstractBaseService<BookChapter> {

    @Autowired
    private BookChapterMapper bookChapterMapper;

    @Override
    public PageVO<BookChapter> getPageList(Params params) {
        Integer page = params.getInt("page");
        Integer limit = params.getInt("limit");
        // 查询条件
        Integer bookId = params.getInt("bookId");
        PageHelper.startPage(page, limit);
        Page<BookChapter> pageList = (Page<BookChapter>) bookChapterMapper.findPageWithResult(bookId);
        return new PageVO<>(pageList.getTotal(),200,"",pageList);
    }

}
