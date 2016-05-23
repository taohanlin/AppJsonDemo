package com.thl.record;

import java.util.List;

import com.jfinal.ext.plugin.tablebind.TableBind;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;

@TableBind(tableName="user_info")
public class UserModel extends Model<UserModel>{

  public static final UserModel Dao=new UserModel();

  private static final long serialVersionUID = 1L;

  
  /**
   * @Description 查询用户所有信息
   * @author taohanlin(898899528@qq.com)
   * @date 2016年5月19日 下午3:52:54
   * @action finaAll
   * @return List<Record>
   */
  public List<Record> finaAll(){
    List<Record> find = Db.find("select * from user_info");
    return find;
  }
  
 
}
