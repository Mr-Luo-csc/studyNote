package csc.lzp.controller;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WebSocketController {

    /**
     * 给其它页面来异步刷新报表操作的接口
     */
    @RequestMapping(value = "/update")
    public Map<String, String> update(@RequestParam("value") String value) {
        Map<String, String> map = new HashMap<>();
        map.put("v", value);
        return map;
    }

    @MessageMapping(value = "/view")
    @SendTo("/topic/echarts")
    public String webSocket(Message message) {
        byte[] bytes = (byte[]) message.getPayload();
        String str = new String(bytes);
        System.out.println("输出: " + str);
        return "0731";
    }

}
