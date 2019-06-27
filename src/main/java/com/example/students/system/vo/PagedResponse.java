package com.example.students.system.vo;

import java.util.List;

public class PagedResponse<T> {
    private int page;
    private int rows;
    private int totalPage;
    private long totalElement;
    private String order;
    private List<T> body;
}