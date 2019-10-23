package com.java.base.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName UrlDemo
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/6 14:20
 * @Version 1.0
 **/
public class UrlDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.sina.com.cn/");
            System.out.println(url.getHost());
            System.out.println(url.getProtocol());
            System.out.println(url.getPort());
            System.out.println(url.getDefaultPort());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
