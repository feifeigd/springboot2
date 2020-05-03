package com.d7kj.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/// 注入属性组
@ConfigurationProperties("server")
@Configuration
@Data
public class ServerConfig {
    int port;
    String contextPath;
}
