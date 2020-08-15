package csc.lzp.app.application;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class MySpringApplication {

    //======模拟springboot的run方法
    public static void run() throws ServletException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8888);

        //code资源路径
        String sourcePath = MySpringApplication.class.getResource("/").getPath();
        //向tomcat中添加一个webapp项目
        Context context = tomcat.addWebapp("/", new File("src/main/webapp").getAbsolutePath());

        WebResourceRoot resource = new StandardRoot(context);

        resource.addPreResources(new DirResourceSet(resource, "/WEB-INF/classes", sourcePath, "/"));

        context.setResources(resource);

        try {
            tomcat.start();
            tomcat.getServer().wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
