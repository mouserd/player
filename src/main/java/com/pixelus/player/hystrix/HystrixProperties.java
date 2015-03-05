package com.pixelus.player.hystrix;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "hystrix", ignoreUnknownFields = true)
public class HystrixProperties {

    boolean enabled = false;
    boolean streamEnabled = false;
    String streamUrl = "/hystrix.stream";
}
