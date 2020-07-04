package csc.lzp.logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/4
 **/
public class Jcl {

    public static void main(String[] args) {
        Log log= LogFactory.getLog("Jcl");
        log.info("这是: Jcl");
    }

}
