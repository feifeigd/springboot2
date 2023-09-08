package com.d7kj.util;

import org.lionsoul.ip2region.xdb.Header;
import org.lionsoul.ip2region.xdb.Searcher;

import java.io.IOException;
import java.util.Date;

/// ip换算城市
/// https://gitee.com/lionsoul/ip2region
/// 默认的格式：
/// 国家|区域|省份|城市|ISP
public class IpUtil {
    static Searcher searcher;

    public static void init(String dbPath) throws IOException {
        byte[] buff = Searcher.loadContentFromFile(dbPath);
        searcher = Searcher.newWithBuffer(buff);
        Header header = Searcher.loadHeaderFromFile(dbPath);
        Date date = new Date((long)header.createdAt * 1000);
        System.out.println("IpUtil Db info: " + header + date);
    }

    public static String getAddressInfoByIp(String ip) throws Exception {
        if (null == searcher)return "未知";
        return searcher.search(ip);
    }
}
