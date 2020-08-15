package csc.lzp.app;

import csc.lzp.app.application.MySpringApplication;

import javax.servlet.ServletException;

public class ApplicationRunTest {

    //======测试启动,访问localhost:8888
    public static void main(String[] args) {
        try {
            MySpringApplication.run();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

}
