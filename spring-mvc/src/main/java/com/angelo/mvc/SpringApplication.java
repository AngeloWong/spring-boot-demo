package com.angelo.mvc;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResource;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class SpringApplication {

    public static void run() {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9080);

        String sourcePath = SpringApplication.class.getResource("/").getPath();
        int index = sourcePath.indexOf("/spring-mvc");
        String webappPath = sourcePath.substring(0, index) + "/spring-mvc/src/main/webapp";
        // 告诉tomcat 源码在哪里
        Context context = null;
        try {
            context = tomcat.addWebapp("/", new File(webappPath).getAbsolutePath());
            WebResourceRoot webResourceRoot = new StandardRoot(context);
            webResourceRoot.addPreResources(new DirResourceSet(webResourceRoot, "/WEB-INF/classes", sourcePath, "/"));
            context.setResources(webResourceRoot);

            tomcat.start();
            tomcat.getServer().await();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }
}
