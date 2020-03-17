package cn.zealon.book.system.attachment.dao;

import cn.zealon.book.system.attachment.entity.SysAttachment;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 附件管理
 * @author: zealon
 * @since: 2019/10/24
 */
public interface SysAttachmentMapper {

    int deleteByPrimaryKey(String id);

    int insert(SysAttachment sysAttachments);

    int updateByPrimaryKeySelective(SysAttachment sysAttachment);

    SysAttachment selectById(String id);

    /**
     * 获取用户头像（多个附件的话只返回一个）
     * @param uid
     * @return
     */
    SysAttachment findUserHead(@Param("documentId") int uid);

    List<SysAttachment> findPageWithResult(@Param("documentId") int documentId,
                                           @Param("tableCode") String tableCode,
                                           @Param("tableField") String tableField);

    Integer findPageWithCount(@Param("documentId") int documentId,
                              @Param("tableCode") String tableCode,
                              @Param("tableField") String tableField);

}
