package com.thl.service.impl;

import java.util.List;
import java.util.Objects;

import com.jfinal.plugin.activerecord.Record;
import com.thl.record.UserModel;
import com.thl.resp.Response;
import com.thl.resp.ReturnMsg;
import com.thl.service.UserService;

public class UserServiceImpl implements UserService{

//查询所有用户信息
  @Override
  public ReturnMsg findAllUser() {
    ReturnMsg msg=new ReturnMsg(Response.ERROR);
    List<Record> finaAll = UserModel.Dao.finaAll();
    if (Objects.nonNull(finaAll)) {
     msg=new ReturnMsg(Response.SUCCESS);     msg.setData(finaAll);
    }
    return msg;
  }
//通过用户id查询用户信息
  @Override
  public ReturnMsg findUserById(Integer userId) {
    ReturnMsg msg=new ReturnMsg(Response.ERROR);
    Record findUserById = UserModel.Dao.findUserById(userId);
    if (Objects.nonNull(findUserById)) {
      msg=new ReturnMsg(Response.SUCCESS);
      msg.setData(msg);
    }
    return msg;
  }

}
