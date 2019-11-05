package com.taotao.common.pojo;

/**
 * @author 张剑锋
 * @date 2019/4/3 - 15:11
 *
 * easyUI 树形控制节点格式
 */

public class EUTreeNode {

    private long id;
    private String text;
    private String state;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
