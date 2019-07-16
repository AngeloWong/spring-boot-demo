# web-socket-demo
Web Socket 演示项目：实现在线用户展示、一对一在线聊天

Web Socket是一种协议，基于HTTP的协议
 * 使用web socket的时候，一般结合spring、STOMP的子协议（规范了web socket传输的内容，让web socket变成了订阅-发布的模式）  => 扩展：RabbitMQ 也使用了该STOMP协议
 * web socket是HTML5 新特性，需要浏览器支持，还需要服务端支持，这个服务端指的是web容器（tomcat/jetty）
 * 结合 https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#websocket-stomp 中 4.4.5. Flow of
  Messages 图所示
     * /app 请求的话，会进入SimpAnnotationMethod（可看作Controller）进行后台处理
     * /topic 请求的话，由SimpleBroker(可看作Tomcat)发送给订阅该请求的用户，都无需进入后台程序
