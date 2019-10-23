package com.java.base.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName UrlConnectionDemo
 * @Description TODO
 * @Author LiJialiang
 * @Date 2019/7/6 14:43
 * @Version 1.0
 **/
public class UrlConnectionDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.sina.com.cn/");
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
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

    public static String send(String url, String param) {
        String result = "";
        BufferedReader bufferedReader = null;
        try {
            String urlName = url+"?"+param;
            URL cs = new URL(urlName);
            /*get urlConnection*/
            URLConnection connection = cs.openConnection();
            /*set connection property*/
            connection.setRequestProperty("accept","*/*");
            connection.setRequestProperty("connection","Keep-Alive");
            /*connect*/
            connection.connect();
            /*read*/
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return result;
    }

    /**
     * @Author liJialiang
     * @Description //TODO
     * @Date 2019/7/6 15:27 
     * @Param [url, param] 
     * @return java.lang.String
     **/
    public static String post(String url,String param) {
        String result = "";
        PrintStream ps = null;
        BufferedReader bufferedReader = null;
        try {
            /*get urlConnection*/
            URL cs = new URL(url);
            URLConnection conn = cs.openConnection();
            /*set connection property*/
            conn.setRequestProperty("accept","*/*");
            conn.setRequestProperty("connection","Keep-Alive");
            conn.setDoOutput(true);
            /*set printStream, print,flush*/
            ps = new PrintStream(conn.getOutputStream());
            ps.print(param);
            ps.flush();
            /*bufferedReader read*/
            bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /*close stream*/
            if (ps != null) {
                ps.close();
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  result;
    }
}
