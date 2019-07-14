package com.angelo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class IndexController {

    @RequestMapping("/index.do")
    public String index() {
        return "index";
    }

    @RequestMapping("/update.do")
    public void update(@RequestPart("file") MultipartFile multipartFile) throws IOException {
        File file = new File("D:\\aa");
        multipartFile.transferTo(file);
        System.out.println("此处可使用FileCopyUtils.copy(...) 方法");
    }
}
