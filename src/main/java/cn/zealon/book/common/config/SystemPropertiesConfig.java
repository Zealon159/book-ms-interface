package cn.zealon.book.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 系统属性文件配置
 * @author: zealon
 * @since: 2019/10/25
 */
@Component
@ConfigurationProperties("system.properties")
public class SystemPropertiesConfig {
    /** 删除开关 */
    private Boolean deleteSwitch;
    /** 上传白名单 */
    private String uploadWhite;
    /** 上传路径 */
    private String uploadPath;
    /** 附件根目录 */
    private String attachmentDir;
    /** 访问地址 */
    private String attachmentAccess;

    public Boolean getDeleteSwitch() {
        return deleteSwitch;
    }

    public void setDeleteSwitch(Boolean deleteSwitch) {
        this.deleteSwitch = deleteSwitch;
    }

    public String getUploadWhite() {
        return uploadWhite;
    }

    public void setUploadWhite(String uploadWhite) {
        this.uploadWhite = uploadWhite;
    }

    public String getAttachmentDir() {
        return attachmentDir;
    }

    public void setAttachmentDir(String attachmentDir) {
        this.attachmentDir = attachmentDir;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getAttachmentAccess() {
        return attachmentAccess;
    }

    public void setAttachmentAccess(String attachmentAccess) {
        this.attachmentAccess = attachmentAccess;
    }
}
