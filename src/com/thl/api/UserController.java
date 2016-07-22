package com.thl.api;

import com.jfinal.core.Controller;
import com.thl.resp.ReturnMsg;
import com.thl.service.UserService;
import com.thl.service.impl.UserServiceImpl;

/**
 * @Description: user用户控制器
 * @author taohanlin(898899528@qq.com)
 * @date 2016年5月19日 下午2:56:33
 */
public class UserController extends Controller {
  private static UserService userSrevice = new UserServiceImpl();


  /**
   * @Description 转到index页面
   * @author taohanlin(898899528@qq.com)
   * @date 2016年7月22日 上午11:44:17
   * @action index
   * @return void
   */
  public void index() {
    render("/index.jsp");
  }

  /**
   * @Description 查询用户表所有信息
   * @author taohanlin(898899528@qq.com)
   * @date 2016年5月19日 下午4:06:49
   * @action findUserAll
   * @return void
   */
  public void findUserAll() {
    ReturnMsg findAllUser = userSrevice.findAllUser();
    renderJson(findAllUser);
  }

  /**
   * @Description 通过id查询用户
   * @author taohanlin(898899528@qq.com)
   * @date 2016年5月23日 下午2:32:38
   * @action findUserByName
   * @return void
   */
  public void findUserById() {
    Integer userId = this.getParaToInt("userId", 1);
    ReturnMsg result = userSrevice.findUserById(userId);
    renderJson(result);

  }

}
