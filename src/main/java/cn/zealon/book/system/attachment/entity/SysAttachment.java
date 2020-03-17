package cn.zealon.book.system.attachment.entity;

import java.util.Date;

/**
 * 通用附件
 * @author: zealon
 * @since: 2019/10/24
 */
public class SysAttachment {

    private String id;

    /** 实例ID */
    private int documentId;

    /**
     * 所属表(book,book_author,org_user)
     */
    private String tableCode;

    /**
     * 所属字段(前端定义)
     */
    private String tableField;

    /**
     * 附件名称
     */
    private String name;

    /**
     * 相对路径
     */
    private String filePath;

    /**
     * 扩展名
     */
    private String extName;

    /**
     * 附件大小
     */
    private String fileSize;

    /**
     * 创建人
     */
    private String creater;

    /**
     * 创建时间
     */
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public String getTableField() {
        return tableField;
    }

    public void setTableField(String tableField) {
        this.tableField = tableField;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public SysAttachment(){}

    /**
     * 应用于更新附件所属表单实例ID
     * @param id
     * @param documentId
     */
    public SysAttachment(String id, int documentId) {
        this.id = id;
        this.documentId = documentId;
    }
}
