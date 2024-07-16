package cn.lanqiao.rbac.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public Result(){
        this.code = 200;
        this.message = "操作成功";
    }

    /**
     * 用于@valid错误处理
     * @param code 错误码
     * @param message 错误提示信息
     */
    public Result(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    /**
     * 用于封装返回数据
     * @param data 返回数据
     */
    public Result(T data){
        this();
        this.data = data;
    }
    //系统错误
    public static Result<?> error(Integer code,String message){
        return new Result<>(code,message);
    }
    //操作成功，返回数据
    public static <T> Result<T> success(T data){
        return new Result<>(data);
    }
    //操作成功，无返回数据
    public static  Result<?> success(){
        return new Result<>();
    }
    //操作失败，无返回数据
    public static  Result<?> fail(int code, String message){
        return new Result<>(code,message);
    }
}
