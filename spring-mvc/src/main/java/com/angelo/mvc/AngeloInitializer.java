package com.angelo.mvc;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @HandlesTypes中参数为接口类型
 * Set<Class<?>> set中获取的是所有实现以上接口的实现类
 */
@HandlesTypes(Test.class)
public class AngeloInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("===================AngeloInitializer======================");
        System.out.println(set.toArray()[0]);
    }
}
