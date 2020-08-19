package csc.lzp.mvccase;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: luozhipeng
 * @Date: 2020/8/19
 **/
@Controller
public class IndexController {

    @RequestMapping("/dance")
    @ResponseBody//表示返回json数据 Spring中有很多[处理器],两大类:处理转发页面还是返回数据
    public Map<String, String> dance() {
        System.out.println("======dance======");
        Map<String, String> data = new HashMap<>();
        data.put("Locking", "MrLuo");
        return data;
    }

}
