package cn.zealon.book.common.result;

import java.io.Serializable;

/**
 * 下拉框VO
 * @author: tangyl
 * @since: 2019/10/24
 */
public class SelectVO implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Integer id;
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SelectVO(){}

    public SelectVO(Integer id, String text) {
        this.id = id;
        this.text = text;
    }
}
