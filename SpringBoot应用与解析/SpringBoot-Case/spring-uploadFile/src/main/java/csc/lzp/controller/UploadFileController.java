package csc.lzp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UploadFileController {

    @RequestMapping(value = "/uploadFile")
    public String uploadFile() {


        return "上传文件成功";
    }

}
