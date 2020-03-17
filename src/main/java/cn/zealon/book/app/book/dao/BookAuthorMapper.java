package cn.zealon.book.app.book.dao;

import cn.zealon.book.app.book.entity.BookAuthor;
import cn.zealon.book.common.base.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 图书作者
 * @author: tangyl
 * @since: 2020/3/14
 */
public interface BookAuthorMapper extends BaseMapper<BookAuthor> {

    List<BookAuthor> findPageWithResult(@Param("name") String name);

    Integer findPageWithCount(String name);
}
