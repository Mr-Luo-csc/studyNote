package csc.lzp.actionproxy.sourcefile;

import csc.lzp.actionproxy.dao.CSCDao;

/**
 * @Discription: 表示一个动态代理中的一个代理对象, 这里代表一个源文件, 编译成字节码等JDK转换成一个代理对象
 * @Author: luozhipeng
 **/
public class SourceFile implements CSCDao {
    CSCDao cscDao;

    public SourceFile(CSCDao cscDao) {
        this.cscDao = cscDao;
    }


    public String desc() {
        cscDao.desc();//实现目标对象的逻辑
        System.out.println("长沙的妹妹我带你去喝酒咧");//实现的代理逻辑
        return "麻烦有点大男子主义,男子气概OK? M E N ";
    }

    public String special() {
        cscDao.special();//实现目标对象的逻辑
        System.out.println("CSC shut to 我的祖国");//是想代理的逻辑
        return "SUP吊到不行,你晓得不咯";
    }
}
