package com.taotao.controller;

import com.taotao.common.utils.FtpUtil;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author 张剑锋
 * @date 2019/4/9 - 13:27
 */
public class FTPTest {

    @Test
    public void testFtpClient() throws Exception {
        //创建一个ftpClient对象
        FTPClient ftpClient = new FTPClient();
        //创建ftp连接,端口号默认21
        ftpClient.connect("192.168.223.129",21);
        //登录ftp服务器，使用用户名密码
        ftpClient.login("root","itcast");
        //上传文件
        //读取本地文件
        FileInputStream inputStream = new FileInputStream(new File("E:\\image\\2.jpg"));
        //设置上传的路径
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
        //修改上传问价的格式
        //ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //第一个参数：服务器端文件名
        //第二个参数：上传文件的inputStream
        ftpClient.storeFile("hello2.jpg",inputStream);
        //关闭连接
        ftpClient.logout();

    }


    @Test
    public void testFtpUtils() throws Exception {
        FileInputStream inputStream = new FileInputStream(new File("E:\\image\\1.jpg"));
        FtpUtil.uploadFile("192.168.223.129",21,"root","itcast",
                "/home/ftpuser","/2015/01/21","hello.jpg",inputStream);
    }

}
