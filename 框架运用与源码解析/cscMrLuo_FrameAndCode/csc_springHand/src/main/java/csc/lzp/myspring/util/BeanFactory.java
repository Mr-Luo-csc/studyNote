package csc.lzp.myspring.util;

import org.dom4j.Document;
import org.dom4j.bean.BeanDocumentFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Discription:
 * @Author: luozhipeng
 **/
public class BeanFactory extends BeanDocumentFactory {

    public BeanFactory(String xml) {
        parseXml(xml);
    }

    public static void parseXml(String xml) {
        Map<String, Object> map = new HashMap<String, Object>();
        Document doc = null;
        try {

            File file = new File("");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getBean() {
        return null;
    }
}
