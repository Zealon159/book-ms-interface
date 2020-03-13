package cn.zealon.book.app.dictionary.dao;

import cn.zealon.book.app.dictionary.entity.DataDictionary;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 数据字典
 * @author: tangyl
 * @since: 2020/3/13
 */
public interface DataDictionaryMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(DataDictionary dataDictionary);

    int updateByPrimaryKey(DataDictionary dataDictionary);

    DataDictionary selectById(Integer id);

    DataDictionary selectByDicTypeAndCode(@Param("dicType") String dicType, @Param("code") Integer code);

    List<DataDictionary> findPageWithResult(@Param("dicType") String dicType);

    Integer findPageWithCount(@Param("dicType") String dicType);

}
