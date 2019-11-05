package com.taotao.rest.service;

import com.taotao.common.pojo.TaotaoResult;

/**
 * @author 张剑锋
 * @date 2019/5/16 - 14:23
 */
public interface ItemService {

    TaotaoResult getItemBaseInfo(long itemId);
    TaotaoResult getItemDesc(long itemId);
    TaotaoResult getItemParam(long itemId);
}
