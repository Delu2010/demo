package com.lcd.bloggingsystem.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public static <E> Result<E> success(String message, E data) {
        return new Result<>(0, message, data);
    }

    public static Result success(String message) {
        return new Result<>(0, message, null);
    }

    public static Result error(String message) {
        return new Result<>(1, message, null);
    }
}
