package cn.zealon.book.core.exception;

/**
 * 系统异常基类
 *
 * @Author: zealon
 * @Version: 1.0
 */
public class BaseException extends Exception{
    //异常打印信息
    private String message;

    public BaseException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
