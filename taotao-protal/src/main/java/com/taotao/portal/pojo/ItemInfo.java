package com.taotao.portal.pojo;

import com.taotao.pojo.TbItem;

/**
 * @author 张剑锋
 * @date 2019/5/18 - 13:42
 */
public class ItemInfo extends TbItem {

    public String[] getImages() {
        String image = getImage();
        if (image != null) {
            String[] images = image.split(",");
            return images;
        }
        return null;
    }
}
