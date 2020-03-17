package cn.zealon.book.app.book.entity;

import cn.zealon.book.common.base.BaseEntity;

/**
 * 图书作者
 * @author: tangyl
 * @since: 2020/3/14
 */
public class BookAuthor extends BaseEntity {

    /**
     * 作者名称
     */
    private String name;

    /**
     * 作者简介
     */
    private String introduction;

    /**
     * 头像附件id
     */
    private String headImgUrl;

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

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }
}
