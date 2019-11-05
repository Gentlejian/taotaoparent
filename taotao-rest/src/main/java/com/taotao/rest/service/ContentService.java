package com.taotao.rest.service;

import com.taotao.pojo.TbContent;

import java.util.List;

/**
 * @author 张剑锋
 * @date 2019/4/26 - 13:53
 */
public interface ContentService {

    List<TbContent> getContentList(long contentCid);

}
