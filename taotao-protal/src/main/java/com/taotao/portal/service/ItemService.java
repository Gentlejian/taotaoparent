package com.taotao.portal.service;

import com.taotao.portal.pojo.ItemInfo;

/**
 * @author 张剑锋
 * @date 2019/5/18 - 13:20
 */
public interface ItemService {
    ItemInfo getItemById(Long itemId);
    String getItemDescById(Long itemId);
    String getItemParam(Long itemId);
}
