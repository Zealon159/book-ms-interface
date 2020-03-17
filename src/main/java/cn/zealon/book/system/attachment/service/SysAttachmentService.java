package cn.zealon.book.system.attachment.service;

import cn.zealon.book.common.config.SystemPropertiesConfig;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.util.ResultUtil;
import cn.zealon.book.common.utils.FileHandleUtil;
import cn.zealon.book.common.utils.Utils;
import cn.zealon.book.core.cache.RedisService;
import cn.zealon.book.system.attachment.dao.SysAttachmentMapper;
import cn.zealon.book.system.attachment.entity.SysAttachment;
import cn.zealon.book.system.attachment.vo.SysAttachmentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 附件管理
 * @author: zealon
 * @since: 2019/10/24
 */
@Service
public class SysAttachmentService {

    @Autowired
    private SysAttachmentMapper attachmentMapper;

    @Autowired
    private SystemPropertiesConfig systemPropertiesConfig;

    @Autowired
    private RedisService redisService;

    /**
     * 查询表实例对应的附件列表
     * @param documentId
     * @param tableCode
     * @param tableField
     * @return
     */
    public Result getList(int documentId, String tableCode, String tableField){
        List<SysAttachment> list = attachmentMapper.findPageWithResult(documentId, tableCode, tableField);
        List<SysAttachmentVO> voList = new ArrayList<>(list.size());
        for (SysAttachment attachment : list){
            SysAttachmentVO vo = this.getVO(attachment);
            voList.add(vo);
        }
        return ResultUtil.success(voList);
    }

    /**
     * 关联附件
     * @param documentId
     * @param attachmentIds
     */
    public void relevanceAttachments(Integer documentId, String[] attachmentIds){
        if (Utils.isNotEmpty(attachmentIds)){
            for (int i = 0; i < attachmentIds.length; i++) {
                SysAttachment attachment = new SysAttachment(attachmentIds[i],documentId);
                this.attachmentMapper.updateByPrimaryKeySelective(attachment);
            }
        }
    }

    public Result delete(String id){
        this.attachmentMapper.deleteByPrimaryKey(id);
        return ResultUtil.success();
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public Result deleteBatch(List<String> ids){
        for (int i = 0; i < ids.size(); i++) {
            String id = ids.get(i);
            this.attachmentMapper.deleteByPrimaryKey(id);
        }
        return ResultUtil.success();
    }

    /**
     * 下载附件
     * @param response
     * @param id
     */
    public void download(HttpServletResponse response, String id){
        SysAttachment attachment = this.attachmentMapper.selectById(id);
        try {
            String filePath = this.systemPropertiesConfig.getUploadPath() + attachment.getFilePath() + attachment.getId() + attachment.getExtName();
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            String fileName= URLEncoder.encode(attachment.getName(),"utf-8");
            ByteArrayOutputStream byteArrayOutputStream = FileHandleUtil.InputStreamToByte(bis);
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Content-Length", "" + byteArrayOutputStream.size());
            response.setContentType("application/octet-stream");

            ServletOutputStream outputStream = response.getOutputStream();
            byteArrayOutputStream.writeTo(outputStream);
            outputStream.flush();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SysAttachmentVO getVO(SysAttachment attachment){
        SysAttachmentVO vo = new SysAttachmentVO();
        if (attachment!=null) {
            BeanUtils.copyProperties(attachment, vo);
            String path = "head/"+attachment.getFilePath() + attachment.getId() + attachment.getExtName();
            vo.setFilePath(path);
        }
        return vo;
    }
}
