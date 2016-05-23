package com.thl.service;

import com.thl.resp.ReturnMsg;

/**
 * @Description: user接口
 * @author taohanlin(898899528@qq.com)
 * @date 2016年5月19日 下午3:37:44
 */
public interface UserService {
  
  /**
   * @Description 查询用户表所有数据
   * @author taohanlin(898899528@qq.com)
   * @date 2016年5月19日 下午3:47:57
   * @action findAllUser
   * @return ReturnMsg
   */
  public ReturnMsg findAllUser();

}
