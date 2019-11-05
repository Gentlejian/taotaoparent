package com.taotao.service;

import com.taotao.common.pojo.EUTreeNode;

import java.util.List;

/**
 * @author 张剑锋
 * @date 2019/4/3 - 15:17
 */
public interface ItemCatService {

    /**
     * 接收一个参数（parentId）来查询子类目列表，展示树状结构图
     * @param parentId
     * @return
     */
    List<EUTreeNode> getCatlist(Long parentId);
}
