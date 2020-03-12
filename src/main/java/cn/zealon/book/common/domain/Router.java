package cn.zealon.book.common.domain;

import java.util.List;

/**
 * VUE动态路由对象
 * @author: tangyl
 * @since: 2020/3/10
 */
public class Router {

    private String path;
    private String name;
    private String component;
    private Boolean hidden;
    private List<RouterMeta> meta;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public List<RouterMeta> getMeta() {
        return meta;
    }

    public void setMeta(List<RouterMeta> meta) {
        this.meta = meta;
    }

    public Router(){}

    public Router(String pathUrl, String name, String componentPath, Boolean hidden, List<RouterMeta> meta) {
        this.path = pathUrl;
        this.name = name;
        this.component = componentPath;
        this.hidden = hidden;
        this.meta = meta;
    }
}
