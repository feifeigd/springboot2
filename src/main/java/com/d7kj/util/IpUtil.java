package com.d7kj.util;

import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbMakerConfigException;
import org.lionsoul.ip2region.DbSearcher;

import java.io.FileNotFoundException;
import java.io.IOException;

/// ip换算城市
/// TODO 获取国家和省份
public class IpUtil {

    static DbSearcher dbSearcher;

    public static void init(String path){
        try {
            dbSearcher = new DbSearcher(new DbConfig(), path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DbMakerConfigException e) {
            e.printStackTrace();
        }
    }

    public static String getCityInfoByIp(String ip) throws IOException {
        if (null == dbSearcher)return "未知";
        DataBlock dataBlock = dbSearcher.btreeSearch(ip);
        String region = dataBlock.getRegion().substring(0, dataBlock.getRegion().lastIndexOf("!"));
        String city = region.substring(region.lastIndexOf("|") + 1);
        return  city;
    }
}
