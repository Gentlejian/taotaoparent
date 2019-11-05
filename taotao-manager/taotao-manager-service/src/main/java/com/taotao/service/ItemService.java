package com.taotao.service;


import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * @author 张剑锋
 * @date 2019/4/1 - 22:27
 */
public interface ItemService {

    TbItem getItemById(long itemId);
    EUDataGridResult getItemList(int page, int rows);
    TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception;
}
