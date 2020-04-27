package rediswork.rediswork.common;

import java.io.Serializable;

/**
 * 接口统一返回格式
 * @author liutf
 * @date 2020-02-28
 */
public class ResultVo<T> implements Serializable {
    private static final long serialVersionUID = 2783377098145240357L;
    private Integer code;
    private String message;
    private T data;

    public ResultVo() {
        this.code = 0;
        this.message= "success";
    }

    public ResultVo(T data) {
        this.code = 0;
        this.message= "success";
        this.data = data;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

