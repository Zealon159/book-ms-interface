package cn.zealon.book.app.book.dao;

import cn.zealon.book.app.book.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 图书
 * @author: zealon
 * @since: 2020/3/16
 */
public interface BookMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Book book);

    int updateByPrimaryKey(Book book);

    Book selectById(Integer id);

    Book selectByBookId(String bookId);

    List<Book> findPageWithResult(@Param("dicCategory") Integer dicCategory,
                                  @Param("dicChannel") Integer dicChannel,
                                  @Param("dicSerialStatus") Integer dicSerialStatus,
                                  @Param("onlineStatus") Integer onlineStatus,
                                  @Param("authorId") Integer authorId,
                                  @Param("bookId") String bookId,
                                  @Param("bookName") String bookName);

    Integer findPageWithCount(@Param("dicCategory") Integer dicCategory,
                              @Param("dicChannel") Integer dicChannel,
                              @Param("dicSerialStatus") Integer dicSerialStatus,
                              @Param("onlineStatus") Integer onlineStatus,
                              @Param("authorId") Integer authorId,
                              @Param("bookId") String bookId,
                              @Param("bookName") String bookName);
}
