package cn.zealon.book.common.result;

import java.util.List;

/**
 * Cascader 数据源格式
 * @author: tangyl
 * @since: 2020/2/9
 */
public class CascaderVO {

    private String value;
    private String label;
    private List<CascaderVO> children;

    public CascaderVO(){}

    public CascaderVO(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<CascaderVO> getChildren() {
        return children;
    }

    public void setChildren(List<CascaderVO> children) {
        this.children = children;
    }
}
