package com.example.tcp_item2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by huangcl on 2016/12/16.
 */

public class Server {
    public static final int PORT = 8964;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            StringBuilder b = new StringBuilder();
            byte[] bytes = new byte[1024];
            while (true) {
                Socket accept = serverSocket.accept();
                System.out.println(accept.getInetAddress() + "已连接");
                InputStream inputStream = accept.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);
                int len = 0;
                while ((len = reader.))
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
