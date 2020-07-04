package csc.lzp.test.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import csc.lzp.test.exception.FastJsonUtilException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSONUtils {
    private static final Logger logger = LoggerFactory.getLogger(JSONUtils.class);

    public JSONUtils() {
    }

    public static final <T> T getObject(String jsontext, Class<T> clazz) throws FastJsonUtilException {
        try {
            return JSON.parseObject(jsontext, clazz);
        } catch (Exception var3) {
            logger.error("json字符串转换失败" + jsontext, var3);
            throw new FastJsonUtilException();
        }
    }

    public static final String toJSONString(Object object, boolean prettyFormat) {
        return JSON.toJSONString(object, prettyFormat);
    }

    public static final Object HandlerNull(Object object) {
        return JSON.parse(JSON.toJSONString(object));
    }

    public static final String toJSONString(Object object) {
        return JSON.toJSONString(object);
    }

    public static <T> List<T> getList(String jsonStr, Class<T> clazz) throws FastJsonUtilException {
        new ArrayList();

        try {
            List<T> list = JSON.parseArray(jsonStr, clazz);
            return list;
        } catch (Exception var4) {
            logger.error("json字符串转List失败！" + jsonStr, var4);
            throw new FastJsonUtilException(jsonStr);
        }
    }

    public static List<Map<String, Object>> listKeyMaps(String jsonString) throws FastJsonUtilException {
        new ArrayList();

        try {
            List<Map<String, Object>> list = (List)JSON.parseObject(jsonString, new TypeReference<List<Map<String, Object>>>() {
            }, new Feature[0]);
            return list;
        } catch (Exception var3) {
            logger.error("json字符串转map失败", var3);
            throw new FastJsonUtilException();
        }
    }

    public static Map<String, Object> json2Map(String jsonStr) throws FastJsonUtilException {
        try {
            return (Map)JSON.parseObject(jsonStr, Map.class);
        } catch (Exception var2) {
            logger.error("json字符串转换失败！" + jsonStr, var2);
            throw new FastJsonUtilException();
        }
    }

    public static final <T> List<T> getList(String jsontext, String list_str, Class<T> clazz) {
        JSONObject jsonobj = JSON.parseObject(jsontext);
        if (jsonobj == null) {
            return null;
        } else {
            Object obj = jsonobj.get(list_str);
            if (obj == null) {
                return null;
            } else if (!(obj instanceof JSONArray)) {
                return null;
            } else {
                JSONArray jsonarr = (JSONArray)obj;
                List<T> list = new ArrayList();

                for(int i = 0; i < jsonarr.size(); ++i) {
                    list.add(jsonarr.getObject(i, clazz));
                }

                return list;
            }
        }
    }

    public static final <T> T getObject(String jsontext, String obj_str, Class<T> clazz) {
        JSONObject jsonobj = JSON.parseObject(jsontext);
        if (jsonobj == null) {
            return null;
        } else {
            Object obj = jsonobj.get(obj_str);
            if (obj == null) {
                return null;
            } else if (obj instanceof JSONObject) {
                return jsonobj.getObject(obj_str, clazz);
            } else {
                logger.info(obj.getClass() + "");
                return null;
            }
        }
    }

    public static byte[] strToByteArray(String str) {
        if (str == null) {
            return null;
        } else {
            byte[] byteArray = str.getBytes();
            return byteArray;
        }
    }

    public static String byteArrayToStr(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        } else {
            String str = new String(byteArray);
            return str;
        }
    }

    public static final Object getObject(byte[] bytes) throws FastJsonUtilException {
        try {
            String jsontext = "";
            jsontext = byteArrayToStr(bytes);
            return JSON.parse(jsontext);
        } catch (Exception var2) {
            logger.error("json字符串转换失败", var2);
            throw new FastJsonUtilException();
        }
    }

    public static final byte[] toJSONByte(Object object) {
        String str = JSON.toJSONString(object);
        return strToByteArray(str);
    }
}
