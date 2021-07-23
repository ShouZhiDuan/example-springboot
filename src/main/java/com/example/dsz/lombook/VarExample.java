package com.example.dsz.lombook;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2020/12/23 9:53
 * @Description:
 */
public class VarExample {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("Local HostAddress: " + addr.getHostAddress());
        String hostname = addr.getHostName();
        System.out.println("Local host name: " + hostname);
    }
}
