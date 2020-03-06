package cn.zealon.book.common.result;

import java.util.List;

/**
 * 树对象
 * @author: tangyl
 * @since: 2020/3/4
 */
public class TreeDataVO {
    private Integer id;
    private String label;
    private List<TreeDataVO> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<TreeDataVO> getChildren() {
        return children;
    }

    public void setChildren(List<TreeDataVO> children) {
        this.children = children;
    }
}
