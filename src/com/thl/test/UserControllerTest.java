package com.thl.test;

import com.jfinal.ext.test.ControllerTestCase;
import com.thl.cfg.AppJsonConfig;

/**
 * @Description: 用户表测试类
 * @author taohanlin(898899528@qq.com)
 * @date 2016年5月23日 下午2:43:49
 */
public class UserControllerTest extends ControllerTestCase<AppJsonConfig>{
  
  @org.junit.Test
  public void test(){
    Integer userId=2;
    String url="http://114.215.104.154:8080/user/findUserById?userId="+userId;
    String invoke = use(url).post("").invoke();
    System.out.println(invoke);
  }

}
