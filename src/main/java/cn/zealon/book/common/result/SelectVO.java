package cn.zealon.book.common.result;

import java.io.Serializable;

/**
 * 下拉框VO
 * @author: tangyl
 * @since: 2019/10/24
 */
public class SelectVO implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String id;
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SelectVO(){}

    public SelectVO(String id, String text) {
        this.id = id;
        this.text = text;
    }
}
