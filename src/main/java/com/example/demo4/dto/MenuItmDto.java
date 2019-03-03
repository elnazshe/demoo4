package com.example.demo4.dto;

import java.util.List;


public class MenuItmDto {

    private com.example.demo4.dto.MenuItemType type;

    private String title;

    private com.example.demo4.dto.UIPageDto page;

    private List<MenuItmDto> children;


    public MenuItmDto() {
    }

    public MenuItmDto(com.example.demo4.dto.MenuItemType type, String title, com.example.demo4.dto.UIPageDto page, List<MenuItmDto> children) {
        this.type = type;
        this.title = title;
        this.page = page;
        this.children = children;
    }

    public com.example.demo4.dto.MenuItemType getType() {
        return type;
    }

    public void setType(com.example.demo4.dto.MenuItemType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public com.example.demo4.dto.UIPageDto getPage() {
        return page;
    }

    public void setPage(com.example.demo4.dto.UIPageDto page) {
        this.page = page;
    }

    public List<MenuItmDto> getChildren() {
        return children;
    }

    public void setChildren(List<MenuItmDto> children) {
        this.children = children;
    }
}