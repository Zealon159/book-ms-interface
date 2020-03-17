package cn.zealon.book.app.book.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 图书
 * @author: zealon
 * @since: 2020/3/16
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 作者
     */
    private Integer authorId;

    /**
     * 分类
     */
    private Integer dicCategory;

    /**
     * 频道id:0全部,1男生,2女生,3出版物
     */
    private Integer dicChannel;

    /**
     * 连载状态
     */
    private Integer dicSerialStatus;

    /**
     * 状态：0下架，1上架
     */
    private Boolean onlineStatus;

    /**
     * 图书id
     */
    private String bookId;

    /**
     * 图书名称
     */
    private String bookName;

    /**
     * 图书评分
     */
    private Integer bookScore;

    /**
     * 关键词
     */
    private String keyWord;

    /**
     * 封面
     */
    private String imgUrl;

    /**
     * 作者名称
     */
    private String authorName;

    /**
     * 简介
     */
    private String introduction;

    /**
     * isbn
     */
    private String isbn;

    /**
     * 字数
     */
    private Integer wordCount;

    /**
     * 创建者
     */
    private String creater;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新者
     */
    private String updater;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getDicCategory() {
        return dicCategory;
    }

    public void setDicCategory(Integer dicCategory) {
        this.dicCategory = dicCategory;
    }

    public Integer getDicChannel() {
        return dicChannel;
    }

    public void setDicChannel(Integer dicChannel) {
        this.dicChannel = dicChannel;
    }

    public Integer getDicSerialStatus() {
        return dicSerialStatus;
    }

    public void setDicSerialStatus(Integer dicSerialStatus) {
        this.dicSerialStatus = dicSerialStatus;
    }

    public Boolean getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookScore() {
        return bookScore;
    }

    public void setBookScore(Integer bookScore) {
        this.bookScore = bookScore;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
