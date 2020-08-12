package csc.lzp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UploadFileController {

    @RequestMapping(value = "/uploadFile")
    public String uploadFile() {
        //TODO 模拟文件上传成功,这里已经从前端拿到的文件数据 可以[使用输出流 写数据到文件服务器]

        return "上传文件成功";
    }

}
