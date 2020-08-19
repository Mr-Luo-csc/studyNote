package csc.lzp.webapp.init;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/18
 **/
public class SpringApplicationRunClass {

    public static void run() throws Exception {
        //初始化springWeb环境
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(AppConfig.class);
        webApplicationContext.refresh();

        File base = new File(System.getProperty("java.io.tmpdir"));

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        //todo contextPath-表示tomcat的访问路径 docBase-表示项目的web目录(可以指定外部的)
        Context context = tomcat.addContext("/", base.getAbsolutePath());

        //Servlet中传springWeb上下文环境
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

        Tomcat.addServlet(context, "luozhipeng", dispatcherServlet).setLoadOnStartup(0);
        context.addServletMapping("/", "luozhipeng");

        tomcat.start();//启动
        tomcat.getServer().await();//等待请求
    }

}
