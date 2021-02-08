package com.jack.api.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class NetworkUtil {
    /**
     * @param remoteInetAddr IP地址或域名
     * @param out_time    超时间隔，单位为毫秒
     * @return
     * @throws IOException
     */
    public static boolean ping(String remoteInetAddr, int out_time)
            throws IOException {
        boolean reachable = false;
        try {
            InetAddress address = InetAddress.getByName(remoteInetAddr);
            reachable = address.isReachable(out_time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reachable;
    }

    public static void main(String[] args) throws IOException {

    }
}
