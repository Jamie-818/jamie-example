package com.jamie.example.netty.springboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自定义netty配置类
 * @author jamie
 */
@Component
@ConfigurationProperties(prefix = "netty")
@Data
public class NettyConfig {

    /** netty监听的端口 */
    private int port;

    /** websocket访问路径 */
    private String path;

}
