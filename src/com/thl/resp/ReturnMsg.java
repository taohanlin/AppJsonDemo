package com.thl.resp;

/**
 * @Description: 返还数据的封装类
 * @author taohanlin(898899528@qq.com)
 * @date 2016年5月19日 下午3:38:37
 */
public class ReturnMsg {
  private String code;
  private String msg;
  private Object data;
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public String getMsg() {
    return msg;
  }
  public void setMsg(String msg) {
    this.msg = msg;
  }
  public Object getData() {
    return data;
  }
  public void setData(Object data) {
    this.data = data;
  }
  public ReturnMsg(String code, String msg, Object data) {
    super();
    this.code = code;
    this.msg = msg;
    this.data = data;
  }
  public ReturnMsg() {
    super();
    // TODO Auto-generated constructor stub
  }
  public ReturnMsg(Response response, Object data) {
    super();
    this.code = response.getCode();
    this.msg = response.getName();
    this.data=data;
  }
  public ReturnMsg(Response resonse) {
    this.code = resonse.getCode();
    this.msg = resonse.getName();
  }
  
}
