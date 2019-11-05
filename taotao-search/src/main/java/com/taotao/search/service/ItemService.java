package com.taotao.search.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 张剑锋
 * @date 2019/5/14 - 13:03
 */
public interface ItemService {

    TaotaoResult importAllItems();
}
