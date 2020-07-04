package csc.lzp.test.mytest;

import org.springframework.beans.BeanUtils;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/4
 **/
public class MyTest {

    private String setter;
    private String msg;

    //-------------------克隆方法(浅拷贝)--------------------//
    public static MyTest copyBean(MyTest sourceObj) {
        MyTest target = new MyTest();
        BeanUtils.copyProperties(sourceObj, target);
        return target;
    }

    //-------------------判空方法--------------------//
    public static void isEmpty() {

    }

    //-------------------Main测试--------------------//
    /*public static void main(String[] args) {
        MyTest myTest = new MyTest();
        myTest.setSetter("罗志祥");
        myTest.setMsg("Cookie");
        MyTest takeTarget = MyTest.copyBean(myTest);
        System.out.println("得到克隆之后的对象: " + takeTarget.toString());
        System.out.println("sourceObj == targetObj: " + (myTest == takeTarget));
    }*/
    public static void main(String[] args) {
        MyTest myTest = new MyTest("csc","222");
        MyTest myTest1 = new MyTest();
        BeanUtils.copyProperties(myTest, myTest1);
        System.out.println(myTest1.toString());
    }

    //-------------------Setter方法--------------------//
    public void setSetter(String setter) {
        this.setter = setter;
    }

    //-------------------Setter方法--------------------//
    public void setMsg(String msg) {
        this.msg = msg;
    }

    //-------------------重写toString方法--------------------//
    @Override
    public String toString() {
        return "MyTest{" +
                "setter='" + setter + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    //-------------------无参构造方法--------------------//
    public MyTest() {
    }

    //-------------------带参构造方法--------------------//
    public MyTest(String setter, String msg) {
        this.setter = setter;
        this.msg = msg;
    }
}
