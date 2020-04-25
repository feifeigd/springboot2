package com.d7kj.conf;

import com.d7kj.util.IpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class Ip2RegionConfig {
    @Value("ip2region.db")
    String path;

    @PostConstruct
    public void postConstruct(){
        IpUtil.init(path);
        System.out.println("Ip2RegionConfig ok");
    }
}
