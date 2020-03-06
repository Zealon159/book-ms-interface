package cn.zealon.book.system.org.vo;

import java.util.List;

/**
 * 菜单对象
 * @author: tangyl
 * @since: 2020/3/6
 */
public class MenuVO {

    private Integer id;
    private String name;
    private String icon;
    private String path;
    private List<MenuVO> children;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<MenuVO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuVO> children) {
        this.children = children;
    }
}
