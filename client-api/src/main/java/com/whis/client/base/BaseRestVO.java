package com.whis.client.base;


public class BaseRestVO<T> {
    /**
     * @Fields code : 返回码
     */
    private Integer code;

    /**
     * @Fields message :返回信息
     */
    private String message;

    /**
     * @Fields data : 返回结果集
     */
    private T data;

    public BaseRestVO() {
    }

    public BaseRestVO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> BaseRestVO<T> success(T data) {
        return new BaseRestVO<T>(0, null,
                data);
    }

    public static BaseRestVO fail(Integer code, String error) {
        return new BaseRestVO(code, error, null);
    }

    @Override
    public String toString() {
        return "BaseRestVO{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
