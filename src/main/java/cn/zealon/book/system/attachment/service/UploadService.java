package cn.zealon.book.system.attachment.service;

import cn.zealon.book.common.config.SystemPropertiesConfig;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.common.result.util.ResultUtil;
import cn.zealon.book.common.utils.CommonUtil;
import cn.zealon.book.common.utils.IpUtils;
import cn.zealon.book.common.utils.Utils;
import cn.zealon.book.system.attachment.dao.SysAttachmentMapper;
import cn.zealon.book.system.attachment.entity.SysAttachment;
import cn.zealon.book.system.security.shiro.util.UserUtil;
import com.alibaba.druid.util.DruidWebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

/**
 * 普通附件上传服务
 * @author: zealon
 * @since: 2019/10/25
 */
@Service
public class UploadService {

    protected final Logger LOGGER = LoggerFactory.getLogger(UploadService.class);

    @Autowired
    private SystemPropertiesConfig systemPropertiesConfig;

    @Autowired
    private SysAttachmentMapper attachmentMapper;

    /**
     * 上传(多)附件
     * @param files         附件组
     * @param documentId    关联表主键
     * @param tableCode     关联表代码
     * @param tableField    关联表字段
     * @return
     */
    public Result uploadFiles(HttpServletRequest request, MultipartFile[] files, Integer documentId, String tableCode, String tableField) {
        // 获取保存文件的根目录
        String rootPath = systemPropertiesConfig.getUploadPath();

        // 文件相对目录
        String filePath = systemPropertiesConfig.getAttachmentDir()+LocalDate.now().toString()+"/";
        if(Utils.isEmpty(documentId)){
            documentId = 0;
        }

        // 记录已经保存的附件id
        List<Map<String,Object>> attachments = new LinkedList<>();

        // 开始保存文件
        for (MultipartFile file : files) {
            SysAttachment sysAttachment = new SysAttachment();
            String fileName = file.getOriginalFilename();
            sysAttachment.setId(CommonUtil.getUUID());
            sysAttachment.setDocumentId(documentId);
            sysAttachment.setName(fileName);
            sysAttachment.setFilePath(filePath);
            sysAttachment.setFileSize(Utils.readableFileSize(file.getSize()));
            if(fileName != null){
                // 扩展名
                String extName = fileName.substring(fileName.lastIndexOf("."));
                sysAttachment.setExtName(extName);
            }
            sysAttachment.setTableCode(tableCode);
            sysAttachment.setTableField(tableField);
            sysAttachment.setCreateTime(new Date());
            sysAttachment.setCreater(UserUtil.getCurrentUserId());
            attachmentMapper.insert(sysAttachment);

            // 文件落盘
            File fullPath = new File(rootPath + filePath);
            if(!fullPath.exists()){
                fullPath.mkdirs();
            }

            // 追加附件属性
            Map<String,Object> attachment = new HashMap<>();
            attachment.put("id",sysAttachment.getId());
            attachment.put("path",sysAttachment.getFilePath() + sysAttachment.getId() + sysAttachment.getExtName());
            attachments.add(attachment);
            try {
                file.transferTo(new File(fullPath,sysAttachment.getId()+sysAttachment.getExtName()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 白名单正常返回，否则返回指定图片(防止网友上传禁图显示出来)
        Map<String,Object> data = new HashMap<>();
        String ip = IpUtils.getIpAddress(request);
        if (!white(ip)) {
            Map<String, Object> att = attachments.get(0);
            attachments.remove(0);
            Map<String,Object> attachment = new HashMap<>();
            attachment.put("id","220c9298f6474db088f54356bf9a21fc");
            attachment.put("path","attachment/2020-03-18/220c9298f6474db088f54356bf9a21fc.jpg");
            attachments.add(attachment);
            data.put("attachments",attachments);
            LOGGER.info("网友[{}]上传{}",ip,att.get("path"));
            return ResultUtil.success(data).buildMessage("图片已上传，由于演示系统是公开的，指定了默认图片哦，请谅解~");
        }
        // 返回结果
        data.put("attachments",attachments);
        return ResultUtil.successAndNoMsg(data);
    }

    private boolean white(String ip){
        boolean ok = true;
        String whites = this.systemPropertiesConfig.getUploadWhite();
        if (whites != null) {
            ok = false;
            String[] whitesArr = whites.split(",");
            for (int i = 0; i < whitesArr.length; i++) {
                if (whitesArr[i].equals(ip)) {
                    ok = true;
                    break;
                }
            }
        }
        return ok;
    }
}
