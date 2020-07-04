package csc.lzp.logger;

import org.apache.log4j.Logger;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/4
 **/
public class Log4j {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("Log4j");
        logger.info("这是: Log4j");
    }

}
