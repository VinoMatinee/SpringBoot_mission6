package com.basic.myspringboot.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("myprop")
@Getter
@Setter
public class MyPropsProperties {
    private String username;
    private Integer port;
}
