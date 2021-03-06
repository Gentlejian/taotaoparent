package com.taotao.rest.service.impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张剑锋
 * @date 2019/4/24 - 13:27
 *
 * 分类服务
 */
@Service
public class ItemCatSerciceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public CatResult getItemCatList() {

        CatResult catResult = new CatResult();
        //查询分类列表
        catResult.setData(getCatList(0));
        return null;
    }

    /**
     * 查询分类列表的方法
     * @param parentId
     * @return
     */
    private List<?> getCatList(long parentId) {

        //创建查询条件
        TbItemCatExample example = new TbItemCatExample();
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        //返回值list
        List resultList = new ArrayList<>();
        //向list中添加节点
        for(TbItemCat tbItemCat : list) {
            //判断是否为父节点
            if(tbItemCat.getIsParent()) {
                CatNode catNode = new CatNode();
                if(parentId == 0) {
                    catNode.setName("<a href='/products/\"+tbItemCat.getId()+\".html'>\"+tbItemCat.getName()+\"</a>");
                } else {
                    catNode.setName(tbItemCat.getName());
                }
                catNode.setUrl("/products/\"+tbItemCat.getId()+\".html");
                catNode.setItem(getCatList(tbItemCat.getId()));
                resultList.add(catNode);
            //如果是叶子节点
            } else {
                resultList.add("/products/"+tbItemCat.getId()+".html|" + tbItemCat.getName());
            }
        }
        return resultList;
    }
}
