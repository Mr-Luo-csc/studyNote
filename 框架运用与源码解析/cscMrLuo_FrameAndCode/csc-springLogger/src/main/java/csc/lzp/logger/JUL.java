package csc.lzp.logger;

import java.util.logging.Logger;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/4
 **/
public class JUL {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("JUL");
        logger.info("这是: JUL");
    }

}
