package io;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stream {
    public static void main(String[] args) throws IOException {
        InputStream src=new URL("http://mail.ru").openStream();
//        InputStream src = new FileInputStream("d:/mail.txt");
        OutputStream dst=new FileOutputStream("d:/mail.txt");
//        OutputStream dst=new FileOutputStream("d:/google.txt");
        copyByte(src, dst);
        List list
                =Collections.checkedList(new ArrayList(),String.class);
    }

    public static void copy(InputStream src, OutputStream dst) throws IOException {
        while (true) {
            int data = src.read();
            if (data != -1) {
                dst.write(data);
            } else {
                return;
            }
        }
    }
    public static void copyByte(InputStream src,OutputStream dst) throws IOException{
        byte[] buff=new byte[1024*64];
        while(true){
            int count=src.read(buff);
           if(count!=-1){
               dst.write(buff,0,count);
           }
           else {
               return;
           }

        }
    }
}

