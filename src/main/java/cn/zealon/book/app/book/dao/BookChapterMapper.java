package cn.zealon.book.app.book.dao;

import cn.zealon.book.app.book.entity.BookChapter;
import cn.zealon.book.common.base.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 图书章节
 * @author: zealon
 * @since: 2020/3/18
 */
public interface BookChapterMapper extends BaseMapper<BookChapter> {

    List<BookChapter> findPageWithResult(@Param("bookId") Integer bookId);

    int findPageWithCount(@Param("bookId") Integer bookId);
}
