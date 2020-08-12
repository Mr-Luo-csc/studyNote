package csc.lzp.controller;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WebSocketController {

    @RequestMapping(value = "/update")
    public Map<String, String> update(@RequestParam("value") String value) {
        Map<String, String> map = new HashMap<>();
        map.put("v", value);
        return map;
    }

    @RequestMapping(value = "/view")
    @SendTo("/topic/echarts")
    public String webSocket(Message message) {

        System.out.println("开始调用接口==================");
        byte[] bytes = (byte[]) message.getPayload();

        String str = new String(bytes);
        System.out.println("输出: " + str);

        return "0731";
    }

}
