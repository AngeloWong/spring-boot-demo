package com.angelo.boot.autoconfigure.web;


import com.angelo.boot.autoconfigure.condition.ConditionalOnAngelo;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@ConditionalOnAngelo
@Component
@ConfigurationProperties(prefix = "angelo", ignoreUnknownFields = true)
public class AngeloProperties {

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
