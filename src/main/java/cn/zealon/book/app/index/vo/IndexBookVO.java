package cn.zealon.book.app.index.vo;

/**
 * 主页最新图书VO
 * @author: zealon
 * @since: 2020/3/18
 */
public class IndexBookVO {

    private Integer id;

    /**
     * 作者
     */
    private Integer authorId;

    /**
     * 分类
     */
    private Integer dicCategory;

    /** 分类名称 */
    private String dicCategoryName;

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

    public String getDicCategoryName() {
        return dicCategoryName;
    }

    public void setDicCategoryName(String dicCategoryName) {
        this.dicCategoryName = dicCategoryName;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
