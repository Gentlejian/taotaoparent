package com.taotao.portal.service;

import com.taotao.pojo.TbUser;

/**
 * @author 张剑锋
 * @date 2019/5/20 - 10:57
 */
public interface UserService {

    TbUser getUserByToken(String token);
}
