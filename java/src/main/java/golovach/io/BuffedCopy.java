package golovach.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BuffedCopy {
    static void copy(InputStream src, OutputStream dst) throws IOException {

        int count;
        byte[] buff=new byte[1024];

        while((count=src.read(buff))!=-1)
            dst.write(buff,0,count);
        System.out.println("buff = " + buff);
    }

}
