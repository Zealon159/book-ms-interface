package cn.zealon.book.app.book.bo;

/**
 * 作者信息
 * @author: tangyl
 * @since: 2020/3/14
 */
public class BookAuthorBO {

    private Integer id;

    /**
     * 作者名称
     */
    private String name;

    /**
     * 作者简介
     */
    private String introduction;

    /** 头像地址 */
    private String headImgUrl;

    /** 附件ID */
    private String[] attachmentIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String[] getAttachmentIds() {
        return attachmentIds;
    }

    public void setAttachmentIds(String[] attachmentIds) {
        this.attachmentIds = attachmentIds;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
