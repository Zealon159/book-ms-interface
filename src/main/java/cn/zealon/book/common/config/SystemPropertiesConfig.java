package cn.zealon.book.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 系统属性文件配置
 * @author: tangyl
 * @since: 2019/10/25
 */
@Component
@ConfigurationProperties("system.properties")
public class SystemPropertiesConfig {

    /** 上传路径 */
    private String uploadPath;
    /** 附件根目录 */
    private String attachmentDir;
    /** 项目文件附件根目录 */
    private String projectAttachmentDir;
    /** 头像访问地址 */
    private String headAccess;
    /** 模板访问地址 */
    private String templatesAccess;

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

    public String getProjectAttachmentDir() {
        return projectAttachmentDir;
    }

    public void setProjectAttachmentDir(String projectAttachmentDir) {
        this.projectAttachmentDir = projectAttachmentDir;
    }

    public String getHeadAccess() {
        return headAccess;
    }

    public void setHeadAccess(String headAccess) {
        this.headAccess = headAccess;
    }

    public String getTemplatesAccess() {
        return templatesAccess;
    }

    public void setTemplatesAccess(String templatesAccess) {
        this.templatesAccess = templatesAccess;
    }
}
