package com.thl.api;

import java.io.File;

import com.jfinal.core.Controller;

/**
 * @Description: 文件下载
 * @author taohanlin(898899528@qq.com)
 * @date 2016年8月5日 下午1:57:39
 */
public class DownloadController extends Controller{
  
  /**
   * @Description 文件下载
   * @author taohanlin(898899528@qq.com)
   * @date 2016年8月5日 下午1:58:22
   * @action down
   * @return void
   */
  public void down(){
    String path="C:/apache-tomcat-8.0.30/webapps/ROOT/resources/AndroidNetManager.apk";
    File file=new File(path);
    if (file.isFile()) {
      renderFile(file);
      return;
    }
    //renderNull();
   renderJson("文件未找到");

  }
  

}
