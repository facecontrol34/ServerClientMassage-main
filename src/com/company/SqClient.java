package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class SqClient {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("DESKTOP-V6FMBBR", 1020)){
            Scanner scr = new Scanner(System.in);
            String len = scr.nextLine();
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(len.getBytes("UTF-8"));
            outputStream.flush();

            InputStream inputStream = socket.getInputStream();
            byte[] res = new  byte[1024];
            for( int ln; (ln = inputStream.read(res)) != -1;){
                String str = new String(res, 0, ln);
                System.out.println("String client: " + str);
                break;
            }
        }
    }
}
