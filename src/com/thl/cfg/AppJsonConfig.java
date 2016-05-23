package com.thl.cfg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.ext.plugin.sqlinxml.SqlInXmlPlugin;
import com.jfinal.ext.plugin.tablebind.AutoTableBindPlugin;
import com.jfinal.ext.route.AutoBindRoutes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.thl.interceptor.IPInterceptor;

import cn.dreampie.log.Slf4jLogFactory;

/**
 * @Description: 配置插件
 * @author taohanlin(898899528@qq.com)
 * @date 2016年5月19日 下午2:59:16
 */
public class AppJsonConfig extends JFinalConfig{
  
  public static final Logger LOG=LoggerFactory.getLogger(AppJsonConfig.class);
  
  /**
   * @Description pro(生产环境配置文件)，dev(开发环境配置文件)
   * @author taohanlin(898899528@qq.com)
   * @date 2016年5月19日 下午3:06:59
   * @action loadProp
   * @return void
   */
  public void loadProp(String pro, String dev) {
    PropKit.use(pro);
    if (PropKit.getBoolean("devMode", false)) {
        PropKit.useless(pro);
        PropKit.use(dev);
    }
  }

  // 配置log
  @Override
  public void configConstant(Constants me) {
    // me.setBaseViewPath("/html");
    loadProp("pro.txt", "dev.txt");
    me.setDevMode(PropKit.getBoolean("devMode", false));
    me.setLoggerFactory(new Slf4jLogFactory());
    me.setBaseViewPath("/html");
    // ApiConfigKit 设为开发模式可以在开发阶段输出请求交互的 xml 与 json 数据
    ApiConfigKit.setDevMode(me.getDevMode());
    
    me.setError404View("index.html");
    me.setError500View("/html/error/502.html");
    
  }
 
  //命名
  @Override
  public void configHandler(Handlers handlers) {
     handlers.add(new ContextPathHandler("base"));    
  }

  //拦截器
  @Override
  public void configInterceptor(Interceptors interceptors) {
    interceptors.addGlobalActionInterceptor(new IPInterceptor());
    interceptors.add(new SessionInViewInterceptor());
  }

  //配置插件
  @Override
  public void configPlugin(Plugins plugins) {
    C3p0Plugin c3p0=new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password"));
    plugins.add(c3p0);
    
    //自动加载持久层类
    AutoTableBindPlugin arp=new AutoTableBindPlugin(c3p0);
    arp.addScanPackages("com.thl.record");
    arp.setShowSql(true);
    plugins.add(arp);
    
    plugins.add(new SqlInXmlPlugin());
    
  }

  //配置路由
  @Override
  public void configRoute(Routes me) {
    me.add(new AutoBindRoutes());
  }

}
