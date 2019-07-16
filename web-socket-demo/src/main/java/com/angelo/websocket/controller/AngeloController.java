package com.angelo.websocket.controller;

import com.angelo.websocket.util.Contains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class AngeloController {

    @Autowired
    SimpMessagingTemplate template;

    /**
     * 静态映射文件的优先级关系：
     * "classpath:/META-INF/resources/">"classpath:/resources/">"classpath:/static/">"classpath:/public/"
     */
    @PostMapping("/login")
    public String login(String username, HttpSession session) {
        Contains.list.add(username);
        session.setAttribute("uname", username);
        return "redirect:main.html";
    }

    /**
     * 获取当前登录的用户信息
     */
    @RequestMapping("/userInfo")
    @ResponseBody
    public String login(HttpSession session) {
        String info = session.getAttribute("uname").toString();
        return "{\"info\":\"" + info + "\"}";
    }

    /**
     * server 更新在线人数列表的方法
     * 他会给所有订阅了/topic/userList的ws客户端发送消息
     */
    @ResponseBody
    @RequestMapping("/userList")
    public String userList() {
        StringBuilder sb = new StringBuilder();
        String allUser = "";
        for (String user : Contains.list) {
            sb.append(user).append(",");
        }
        if (sb.toString().length() > 0) {
            allUser = sb.toString().substring(0, sb.toString().length() - 1);
        }
        template.convertAndSend("/topic/userList", allUser);
        return "success";
    }

    /**
     * 客户端发送消息方法
     */
    @ResponseBody
    @RequestMapping("/chat")
    public String chat(String message, String username) {
        System.out.println("-------------------" + message + "---" + username);
        //convertAndSend("/user/'user3'/angelo")
        template.convertAndSendToUser(username, "angelo", message);
        return "success";
    }
}
