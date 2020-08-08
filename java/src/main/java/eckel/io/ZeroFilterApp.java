package eckel.io;

import java.io.*;

public class ZeroFilterApp {
    public static void main(String[] args) throws IOException {
        InputStream src=new FileInputStream("d:/src.txt");
        OutputStream dst=new FileOutputStream("d:/dst.txt");
        ZeroFilter.filtrate(src,dst,8);
//        Reader.read(src);
    }
}
class ZeroFilter{
    public static void filtrate(InputStream src, OutputStream dst, int buffSize) throws IOException {
        final int STATE_ZERO = 48;
        final int STATE_NUMBER = 1;
        byte[] buff = new byte[buffSize];
        int count;
        int from = 0;
        while ((count = src.read(buff)) != -1) {
            int state = STATE_ZERO;
            for (int i = 0; i < count; i++) {
                byte value = buff[i];
                switch (state) {
                    case STATE_ZERO:
                        if (value == 48) {
                            state = STATE_ZERO;
                        } else {
                            from = i;
                            state = STATE_NUMBER;
                        }
                        break;

                    case STATE_NUMBER: {
                        if (value == 48) {
                            for (int j = from; j < i; j++) {
                                dst.write(buff[j]);
                            }
                            state = STATE_ZERO;
                        }
                        else if(i==count-1){
                            for (int j = from; j < count; j++) {
                                dst.write(buff[j]);
                        }
                        }
                        else{
                            state = STATE_NUMBER;
                        }
                        break;
                    }
                }
            }


            /*int data=src.read();
            if (data>0){
                dst.write(data);
            }
            else if (data==-1){
                break;
            }*/
        }
    }
}
class Reader{
    public static void read(InputStream src) throws IOException {
        byte[] buff = new byte[10];
        src.read(buff);
        /*while (true){

        }*/
        /*for (int i = 0; i < buff.length; i++) {
            int condition = src.read(buff);
            if (condition != -1) {
                byte value = (byte) src.read();
                buff[i] = value;
            } else return;
            ;
        }
        for (byte b : buff) {
            System.out.println(b);
        }*/
    }
}
