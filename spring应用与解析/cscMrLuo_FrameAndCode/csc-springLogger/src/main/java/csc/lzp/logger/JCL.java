package csc.lzp.logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Discription: 结合了多种实现
 * @Author: luozhipeng
 * @Date: 2020/7/4
 **/
public class JCL {

    public static void main(String[] args) {
        Log log= LogFactory.getLog("JCL");
        log.info("这是: JCL");
    }

}
