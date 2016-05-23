package com.thl.interceptor;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.weixin.sdk.kit.IpKit;
import com.thl.interceptor.IPInterceptor;
import com.thl.resp.AppContant;

/**
 * @Description: 拦截器
 * @author taohanlin(898899528@qq.com)
 * @date 2016年5月19日 下午3:16:02
 */
public class IPInterceptor implements Interceptor{
  private static final Logger LOG = LoggerFactory.getLogger(IPInterceptor.class);

  @Override
  public void intercept(Invocation inv) {
    Controller c=inv.getController();
    HttpServletRequest request=c.getRequest();
    c.setAttr("host", AppContant.HOST);
    String address=IpKit.getRealIp(request);
    Long start=System.currentTimeMillis();
    LOG.warn("ip==="+address);
    inv.invoke();
    Long end=System.currentTimeMillis();
    LOG.error(inv.getActionKey()+"方法调用时间"+(end-start));
  }

}
