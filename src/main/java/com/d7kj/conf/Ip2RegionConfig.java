package com.d7kj.conf;

import com.d7kj.util.IpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;

@Configuration
public class Ip2RegionConfig {
    // @Value("ip2region.db")
    String path = "ip2region.db";

    @PostConstruct
    public void postConstruct() throws FileNotFoundException {
        //path = getClass().getClassLoader().getResource(path).toString();
        IpUtil.init(path);
        System.out.println("Ip2RegionConfig ok");
    }
}
