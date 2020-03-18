package cn.zealon.book.app.index.vo;

/**
 * 主页作者VO
 * @author: zealon
 * @since: 2020/3/18
 */
public class IndexAuthorVO {

    private Integer id;
    private String name;
    private String imgUrl;
    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
