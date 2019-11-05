package com.taotao.service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;

import java.util.List;

/**
 * @author 张剑锋
 * @date 2019/4/24 - 19:06
 */
public interface ContentCategoryService {

    List<EUTreeNode> getCategoryList(long parentId);
    TaotaoResult insertContentCatgory(long parentId,String name);
}
