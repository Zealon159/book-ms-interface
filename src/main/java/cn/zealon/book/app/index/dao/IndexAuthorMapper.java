package cn.zealon.book.app.index.dao;

import cn.zealon.book.app.index.vo.IndexAuthorVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 作者
 * @author: zealon
 * @since: 2020/3/18
 */
public interface IndexAuthorMapper {

    /**
     * 按作品量 - 查询作者排行
     * @param limit
     * @return
     */
    @Select("select a.id,a.name,a.head_img_url imgUrl,(select count(1) num from book where author_id=a.id) num from book_author a " +
            "order by num desc limit #{limit}")
    List<IndexAuthorVO> selectTopAuthors(Integer limit);
}
