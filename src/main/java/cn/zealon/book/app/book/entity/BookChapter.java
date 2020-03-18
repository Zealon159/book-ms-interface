package cn.zealon.book.app.book.entity;

import cn.zealon.book.common.base.BaseEntity;

/**
 * 章节
 * @author: zealon
 * @since: 2020/3/18
 */
public class BookChapter extends BaseEntity {

    /**
     * 所属图书
     */
    private Integer bookId;

    /**
     * 章节名称
     */
    private String name;

    /**
     * 章节内容
     */
    private String content;

    /**
     * 锁章状态(0:无,1:锁章)
     */
    private Boolean lockStatus;

    /**
     * 排序
     */
    private Integer sortNumber;


    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(Boolean lockStatus) {
        this.lockStatus = lockStatus;
    }

    public Integer getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(Integer sortNumber) {
        this.sortNumber = sortNumber;
    }
}
