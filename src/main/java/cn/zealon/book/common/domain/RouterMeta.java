package cn.zealon.book.common.domain;

/**
 * VUE路由元数据
 * @author: tangyl
 * @since: 2020/3/10
 */
public class RouterMeta {
    private String name;
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public RouterMeta(){}

    public RouterMeta(String name, String path) {
        this.name = name;
        this.path = path;
    }
}
