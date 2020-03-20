package cn.zealon.book.app.book.service;

import cn.zealon.book.app.book.dao.BookChapterMapper;
import cn.zealon.book.app.book.entity.BookChapter;
import cn.zealon.book.app.book.vo.ChapterReadVO;
import cn.zealon.book.common.base.AbstractBaseService;
import cn.zealon.book.common.domain.Params;
import cn.zealon.book.common.result.PageVO;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.util.ResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
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

    /**
     * 获取阅读章节信息（当前章节内容、上一章ID、下一章ID）
     * @param id
     * @return
     */
    public Result getReadChapterInfo(Integer id){
        ChapterReadVO vo = new ChapterReadVO();
        BookChapter chapter = this.bookChapterMapper.selectById(id);
        if (chapter != null) {
            BeanUtils.copyProperties(chapter,vo);
            if (chapter.getLockStatus()) {
                vo.setName("不巧啊，本章节内容被锁定，看不了了，ε=(´ο｀*)))");
                vo.setContent("空空如也");
            }
            // 得到前后章节ID
            Integer preId = this.bookChapterMapper.selectPreChapterId(chapter.getBookId(),chapter.getSortNumber());
            Integer nextId = this.bookChapterMapper.selectNextChapterId(chapter.getBookId(),chapter.getSortNumber());
            vo.setPreId(preId);
            vo.setNextId(nextId);
        } else {
            vo.setName("章节被删除了~");
            vo.setContent("空空如也");
        }
        return ResultUtil.successAndNoMsg(vo);
    }
}