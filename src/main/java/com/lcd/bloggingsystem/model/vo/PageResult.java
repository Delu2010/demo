package com.lcd.bloggingsystem.model.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class PageResult<T> implements Serializable {

    // 数据列表
    private List<T> items;

    // 总记录数
    private Long total;

    // 当前页码
    private Long pageNo;

    // 每页记录数
    private Long pageSize;

    public PageResult(List<T> items, Long total, Long pageNo, Long pageSize) {
        this.items = items;
        this.total = total;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

}
