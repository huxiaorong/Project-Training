package com.chinese.config;


import com.chinese.hxr.user.controller.CenterController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;




public class AppConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setViewType(ViewType.JSP);
		me.setError404View("/404.jsp");
		
//		me.setBaseUploadPath(baseUploadPath);
	}

	@Override
	public void onStart() {
		System.out.println("start");
	}

	@Override
	public void onStop() {
		System.out.println("stop");
	}

	@Override
	public void configRoute(Routes me) {
		
		me.add("/center",CenterController.class);
		
	}

	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		DruidPlugin dp = new DruidPlugin("jdbc:mysql://localhost:3306/followmovie?useUnicode=true&characterEncoding=UTF-8", "root", "");
		me.add(dp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
		me.add(arp);
		arp.setDialect(new MysqlDialect());
		
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub

	}

}
