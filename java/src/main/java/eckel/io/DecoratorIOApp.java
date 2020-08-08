package eckel.io;

import java.io.*;
import java.util.Arrays;
import java.util.zip.DeflaterOutputStream;

public class DecoratorIOApp {
    public static void main(String[] args) throws IOException {
//        OutputStream dst=new FileOutputStream("D:/data.bin");
        OutputStream dst = new ByteArrayOutputStream();
        dst = new LogOS("AFTER", dst);
        dst = new BufferedOutputStream(dst, 2);
        dst = new LogOS("BEFORE", dst);
        dst.write(1);
        dst.write(2);
        dst.write(3);
        dst.write(4);
        dst.write(5);
        dst.flush();
    }
}

class LogOS extends OutputStream {
    private final OutputStream impl;
    private final String name;

    LogOS(String name, OutputStream impl) {
        this.impl = impl;
        this.name = name;//discriminator
    }


    @Override
    public void write(int b) throws IOException {
        System.out.println(name + ":write(" + b + ")");
        impl.write(b);

    }

    @Override
    public void write(byte[] b) throws IOException {
        System.out.println(name + ":write(" + Arrays.toString(b) + ")");
        impl.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        System.out.println(name + ":write(" + Arrays.toString(b) + "," + off + "," + len + ")");
        impl.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        System.out.println(name + "flush");
        impl.flush();
    }

    @Override
    public void close() throws IOException {
        impl.close();
    }
}

class DataAdapter {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        OutputStream dst = new BufferedOutputStream(buff, 8 * 1024);
        dst = new BufferedOutputStream(dst, 8 * 1024);
//        dst=new GZIPOutputStream(dst);
        dst = new DeflaterOutputStream(dst);
        DataOutputStream out = new DataOutputStream(dst);//This is an adapter( Double to byte[] )
        long start = System.currentTimeMillis();
        for (int k = 0; k < 1_000_000; k++) {
            out.writeDouble(k % 2 == 0 ? 0.5 : 1.5);
        }
        dst.flush();
        dst.close();
        long stop = System.currentTimeMillis();
        System.out.println("exe time: " + (stop - start)+" ms");
        byte[] rawData = buff.toByteArray();
        System.out.println(rawData.length);
        DataInput src = new DataInputStream(
                new BufferedInputStream(
                        new ByteArrayInputStream(rawData)));
        /*System.out.println(src.readDouble());
        System.out.println(src.readDouble());
        System.out.println(src.readDouble());
        System.out.println(src.readDouble());
        System.out.println(src.readDouble());
    */}
}
