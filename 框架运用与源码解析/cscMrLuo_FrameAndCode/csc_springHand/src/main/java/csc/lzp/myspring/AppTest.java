package csc.lzp.myspring;


import csc.lzp.myspring.util.BeanFactory;

import java.io.UnsupportedEncodingException;

/**
 * @Discription: 测试手写模拟的一个spring
 * @Author: luozhipeng
 * @Date: 2020/5/25
 **/
public class AppTest {

    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory(new AppTest().getPath());
        System.out.println(beanFactory.getBean("userService"));
        //System.out.println("配置文件的输出位置: " + new AppTest().getPath());
    }

    /**
     * 获取的其实是获取编译过后spring.xml配置文件所在的位置
     *
     * @return
     */
    public String getPath() {
        String path = this.getClass().getResource("/").getPath() + "spring.xml";
        try {
            path = java.net.URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return path;
    }
}
