package com.lcd.bloggingsystem.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PageParams {

    // 当前页码
    private Long pageNo = 1L;

    // 每页记录数
    private Long pageSize = 10L;

    // true 正序  false 倒序
    private Boolean orderBy = true;

    public PageParams() {
    }

    public PageParams(Long pageNo, Long pageSize, Boolean orderBy) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.orderBy = orderBy;
    }
}
