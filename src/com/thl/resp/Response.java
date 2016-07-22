package com.thl.resp;

/**
 * @Description: 枚举类
 * @author taohanlin(898899528@qq.com)
 * @date 2016年5月19日 下午3:42:14
 */
public enum Response {
  
  ERROR("13000","出错~"),
  SUCCESS("12000","成功!"),
  FAIL("13000", "请求失败"),
  IMAGE_ERROR("13000","图片上传失败~");

  private String code;
  private String name;
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  private Response(String code, String name) {
    this.code = code;
    this.name = name;
  }
  
  
}
