package golovach.io;

import java.io.*;
import java.net.URL;

public class CopyGoogle {
    public static void main(String[] args) throws IOException {
        URL url=new URL("http://www.google.com");
        InputStream in=url.openStream();
        
        
        OutputStream out=new FileOutputStream("D:\\google.html");
        //copy
        copy(in,out);
//        ArrayList<Integer> list=new ArrayList<>();
//        while (in.read()!=-1)
//            list.add(in.read());

    }

    private static void copy(InputStream src, OutputStream dst) throws IOException {
        Long startTime=System.currentTimeMillis();
        while (true){
            int item=src.read();
            if(item!=-1)
                dst.write(item);
            else
                break;
        }
        Long endTime=System.currentTimeMillis();
        System.out.println("execution time of copy is " + (double)(endTime-startTime)/1000.0+" sec");
    }
}
