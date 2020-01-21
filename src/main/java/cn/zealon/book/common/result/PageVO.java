package cn.zealon.book.common.result;

import java.util.List;

/**
 * 分页封装
 * @author: tangyl
 * @since: 2019/10/23
 */
public class PageVO<T> {

    private long total;
    private int code;
    private String msg;
    private List<T> data;

    public PageVO() {
    }

    public PageVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public PageVO(long count, int code, String msg, List<T> data) {
        this.total = count;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
