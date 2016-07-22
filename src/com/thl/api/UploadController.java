package com.thl.api;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.jfinal.core.Controller;
import com.jfinal.kit.FileKit;
import com.jfinal.upload.UploadFile;
import com.thl.resp.Response;
import com.thl.resp.ReturnMsg;
import com.thl.utils.MyDateKit;
import com.thl.utils.UploadPhoto;

/**
 * @Description: 图片上传接口
 * @author taohanlin(898899528@qq.com)
 * @date 2016年7月22日 上午10:14:35
 */
public class UploadController extends Controller {

  /**
   * @Description 上传图片
   * @author taohanlin(898899528@qq.com)
   * @date 2016年7月22日 上午10:18:36
   * @action uploadPhoto
   * @return void
   */
  public void uploadPhoto() {
    String fileName = "image/";
    ReturnMsg upload = UploadPhoto.uploadPhoto.upload(this, fileName);
    String resultJson = JSON.toJSONString(upload);
    renderJson(resultJson);
  }


  /**
   * @Description 上传文件1
   * @author taohanlin(898899528@qq.com)
   * @date 2016年7月22日 上午11:51:03
   * @action uploadFile
   * @return void
   * @throws IOException
   */
  public void uploadFile() throws IOException {
    // UploadFile files=this.getFile(getPara("file"), "C:/file");
    ReturnMsg msg=new ReturnMsg();
    String extName = "";// 扩展名
    String fileName = "";// 文件名
    String newFileName = "";// 新文件名
    String fileUrl=MyDateKit.format(MyDateKit.DATE_FORMAT);
   // String strPath = JFinal.me().getServletContext().getRealPath("C:/file");
    UploadFile uploadFile = this.getFile("file","C:/apache-tomcat-8.0.30/webapps/ROOT/file/"+fileUrl+"/",1024*1024);
    String uploadName = uploadFile.getFileName();
    // 获取扩展名
    if (uploadName.lastIndexOf(".") > -1) {
      extName = StringUtils.substringAfterLast(uploadName, ".");
      fileName = uploadName.substring(0, uploadName.lastIndexOf("."));
    }
    // 新文件名称
    newFileName =  RandomStringUtils.randomAlphabetic(16)+ "."+extName;
    // 判断是否为图片
    if (!".jpg.gif.png.bmp.JPG.GIF.PNG.BMP".contains(extName)) {
      FileKit.delete(uploadFile.getFile());
      msg=new ReturnMsg(Response.IMAGE_ERROR);
      renderJson(msg);
      return;
    } else {
      File f = uploadFile.getFile();
      InputStream is = new FileInputStream(f);
      OutputStream os = new FileOutputStream(new File("C:/apache-tomcat-8.0.30/webapps/ROOT/file/"+fileUrl+"/"+File.separator + newFileName));

      // 判断文件大小
      byte[] buffer = new byte[1024 * 1024];
      try {
        while (is.read(buffer) > 0) {
          os.write(buffer);
        }
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        if (is != null) {
          is.close();
        }
        if (os != null) {
          os.close();
        }
      }
      // 删除原文件
     FileKit.delete(uploadFile.getFile());
     msg=new ReturnMsg(Response.SUCCESS);
     Map<String, String> map=Maps.newHashMap();
     //http://114.215.104.154/file/1.jpg
     map.put("newFileName", "http://114.215.104.154/file/"+fileUrl+"/"+newFileName);
     msg.setData(map);
     renderJson(msg);

    }



  }



}
