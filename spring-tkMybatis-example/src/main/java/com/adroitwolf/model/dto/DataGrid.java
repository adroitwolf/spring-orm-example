package com.adroitwolf.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName DataGrid.java
 * @Description 分页数据的包装类
 * @createTime 2021年03月02日 08:08:00
 */
@Data
public class DataGrid<T> {
    private long total;
    private List<T> row;
}
