package eckel.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Buffer {
    public static void main(String[] args) throws FileNotFoundException {
        OutputStream dst=new FileOutputStream("d:/tmp.bin");
        dst=new BufferedOutputStream(dst);
    }
}
