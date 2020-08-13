package csc.lzp.socketapp.controller;

import csc.lzp.socketapp.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 接口层
 * @Author: luozhipeng
 * @Date: 2020/8/13
 **/
@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate template;

    /**
     * 用户登录接口
     */
    @RequestMapping(value = "/login")
    public void login(String username, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //维护一个在线人员的列表
        Constants.userNameList.add(username);
        //把当前登录人存到session
        request.getSession().setAttribute("userName", username);
        response.sendRedirect("main.html");
    }

    /**
     * 获取在线人数接口
     */
    @RequestMapping(value = "/userList")
    @ResponseBody
    public String userList() {
        String allUser = "";
        for (String singleUserName : Constants.userNameList) {
            allUser += singleUserName + ",";
        }
        //allUser = allUser.substring(0, allUser.length() - 1);
        System.out.println("全部用户:" + allUser);
        template.convertAndSend("/topic/userList", allUser);
        return "获取在线人数成功";
    }

    /**
     * 获取当前登录用户
     */
    @RequestMapping(value = "userInfo")
    @ResponseBody
    public String userIno(HttpServletRequest request) {
        String userName = request.getSession().getAttribute("userName").toString();
        return "{\"userName\":\"" + userName + "\"}";
    }

}
