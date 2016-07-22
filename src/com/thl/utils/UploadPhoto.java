package com.thl.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import com.jfinal.core.Controller;
import com.thl.oss.OSSConfigure;
import com.thl.oss.OSSManageUtil;
import com.thl.resp.Response;
import com.thl.resp.ReturnMsg;

/**
 * @Description: OSS上传
 * @author taohanlin(898899528@qq.com)
 * @date 2016年7月21日 下午7:47:27
 */
public class UploadPhoto {
  
  public static UploadPhoto uploadPhoto=new UploadPhoto();
  
  public ReturnMsg upload(Controller c,String fileName){
    ReturnMsg result = null;
    try {
      StringBuffer dirName = new StringBuffer();
      // "huahan/app/doctor/"
      dirName.append(fileName);
      dirName.append(MyDateKit.format(MyDateKit.DATE_FORMAT));
      HttpServletRequest request = c.getRequest();
      if (ServletFileUpload.isMultipartContent(request)) {
        DiskFileItemFactory dff = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(dff);
        sfu.setFileSizeMax(20 * 1024 * 1024);
        List<FileItem> items = sfu.parseRequest(request);
        List<String> photos = new ArrayList<String>();
        for (int i = 0; i < items.size(); i++) {
          FileItem fis = items.get(i);
          if (!fis.isFormField() && fis.getName().length() > 0) {
            String lastname = StringUtils.substringAfterLast(fis.getName(), ".");
            if (StringUtils.isBlank(lastname)) {
              lastname = "png";
            }
            String filname = RandomStringUtils.randomAlphabetic(16) + "." + lastname;
            InputStream in = fis.getInputStream();
            OSSConfigure ossConfigure = new OSSConfigure();
            String phototUrl =
                OSSManageUtil.uploadFile(ossConfigure, in, dirName.toString(), filname);
            photos.add(phototUrl);
          }
        }
        if (photos.size() <= 0) {
          result = new ReturnMsg(Response.FAIL);
          result.setData("上传失败");
        } else {
          result = new ReturnMsg(Response.SUCCESS);
          result.setData(photos);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      result = new ReturnMsg(Response.FAIL);
      result.setData("上传失败");
    }
    return result;
    
  }
  
  

}
