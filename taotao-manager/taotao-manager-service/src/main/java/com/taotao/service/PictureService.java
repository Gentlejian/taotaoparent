package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @author 张剑锋
 * @date 2019/4/9 - 15:04
 */
public interface PictureService {

    Map uploadPicture(MultipartFile uploadFile);
}
