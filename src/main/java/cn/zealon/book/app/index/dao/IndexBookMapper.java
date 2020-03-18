package cn.zealon.book.app.index.dao;

import cn.zealon.book.app.index.vo.IndexBookVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 主页图书
 * @author: zealon
 * @since: 2020/3/18
 */
public interface IndexBookMapper {

    @Select("SELECT b.id, b.author_id authorId, b.dic_category dicCategory, b.book_id bookId, b.book_name bookName, " +
            "b.book_score bookScore, b.key_word keyWord, b.img_url imgUrl, b.author_name authorName, b.introduction ," +
            "d.name dicCategoryName FROM  book b " +
            "INNER JOIN data_dictionary d on (d.dic_type='category' and d.code=b.dic_category) " +
            "order by create_time desc  limit #{limit};")
    List<IndexBookVO> selectNewBooks(Integer limit);
}
