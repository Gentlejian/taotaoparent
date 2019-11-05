package com.taotao.common.pojo;

import java.util.List;

/**
 * @author 张剑锋
 * @date 2019/4/2 - 19:57
 *
 * 定义两个参数，用来接收分页参数
 */
public class EUDataGridResult {

    private long total;
    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
