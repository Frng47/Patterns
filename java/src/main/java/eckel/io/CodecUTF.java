package eckel.io;

import java.io.*;

public class CodecUTF {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("D:/google.txt");
        OutputStream os = new FileOutputStream("D:/mail.txt");
        byte[] bytes=copy(is, os);
        for(byte iter:bytes){
            String str=String.format("%8s", Integer.toBinaryString(iter & 0xFF)).replace(' ', '0');
            //0xff is an int literal (00 00 00 ff)
            /*The hex literal 0xFF is an equal int(255). Java represents int as 32 bits. It look like this in binary:

            00000000 00000000 00000000 11111111
            When you do a bit wise AND with this value(255) on any number, it is going to mask(make ZEROs) all but the lowest 8 bits of the number (will be as-is).

... 01100100 00000101 & ...00000000 11111111 = 00000000 00000101*/
            System.out.println(str);
        }
    }

    private static byte[] copy(InputStream is, OutputStream os) throws IOException {
        byte[] bytes = new byte[1024*1];
        while (true) {
            int count = is.read(bytes);
            if (count != -1) {
                os.write(bytes, 0, count);
            }
            else break;
        }
        return bytes;

    }
}
