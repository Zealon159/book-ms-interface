package cn.zealon.book.system.attachment.vo;

/**
 * 附件VO
 * @author: zealon
 * @since: 2019/10/25
 */
public class SysAttachmentVO {

    private String id;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
