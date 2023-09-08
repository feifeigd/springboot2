package com.d7kj.conf;

import com.d7kj.util.IpUtil;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Objects;

@Configuration
public class Ip2RegionConfig {
    // @Value("ip2region.db")
    String path = "/ip2region.xdb";

    @PostConstruct
    public void postConstruct() throws IOException {
        path = Objects.requireNonNull(getClass().getResource(path)).getPath();
//        File file = new File(path);
//        if (!file.exists()){
//            throw new FileNotFoundException(path);
//        }
        IpUtil.init(path);
        try {
            String ip = "61.140.181.155";
            String str = IpUtil.getAddressInfoByIp(ip);
            System.out.println(ip + ":" + str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ip2RegionConfig ok");
    }
}
