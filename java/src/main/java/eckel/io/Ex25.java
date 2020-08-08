package eckel.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.zip.*;

public class Ex25 {
    private static int BSIZE=1024;
    public static void main(String[] args) {
        try {
            FileChannel fc=
                    new FileOutputStream("D:\\dev\\Files\\write.txt").getChannel();
            fc.write(ByteBuffer.wrap("Some text new".getBytes()));
            fc.close();
            fc=
                    new RandomAccessFile("D:\\dev\\Files\\write.txt","rw").getChannel();
            fc.position(fc.size());
            fc.write(ByteBuffer.wrap("\nSome neeeew".getBytes() ));
            fc.close();
            fc=
                    new FileInputStream("D:\\dev\\Files\\write.txt").getChannel();
            ByteBuffer buff=
                    ByteBuffer.allocate(BSIZE);
            fc.read(buff);
            buff.flip();
            while(buff.hasRemaining())
                System.out.print((char)buff.get());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class XYZ{
    public static void main(String[] args) {
        ByteBuffer buf=ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,0,'a'});
        buf.rewind();
        System.out.println("Byte buffer");
        while(buf.hasRemaining())
        System.out.println(buf.position()+" -> "+buf.get());

        System.out.println("Char buffer");
        CharBuffer cb=((ByteBuffer)buf.rewind()).asCharBuffer();
        while(cb.hasRemaining())
            System.out.println(cb.position()+" -> "+cb.get());
    }
}

class Endians{
    public static void main(String[] args) {
        ByteBuffer bb=ByteBuffer.wrap(new byte[12]);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));
        bb.rewind();
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));
        bb.rewind();
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));
    }
}

class GZIPcompress{
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\dev\\Files\\test.zip");
        if(!file.exists())
            file.createNewFile();
        String[] text={"Hello!","Buy"};
        FileOutputStream f = new FileOutputStream("D:\\dev\\Files\\test.zip");
        CheckedOutputStream csum =new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out =new BufferedOutputStream(zos);
        zos.setComment("A test of Java Zipping");
// No corresponding getComment(), though.
        for(String arg : text) {
            System.out.println("Writing file " + text);
            BufferedReader in =
                    new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));
            int c;
            while((c = in.read()) != -1)
                out.write(c);
            in.close();
            out.flush();
        }
        out.close();
// Checksum valid only after the file has been closed!
        System.out.println("Checksum: " + csum.getChecksum().getValue());
/*// Now extract the files:
        System.out.println("Reading file");
        FileInputStream fi = new FileInputStream("test.zip");
        CheckedInputStream csumi =
                new CheckedInputStream(fi, new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);
        ZipEntry ze;
        while((ze = in2.getNextEntry()) != null) {
            System.out.println("Reading file " + ze);
            int x;
            while((x = bis.read()) != -1)
                System.out.write(x);
        }
        if(args.length == 1)
            System.out.println("Checksum: " + csumi.getChecksum().getValue());
        bis.close();
// Alternative way to open and read Zip files:
        ZipFile zf = new ZipFile("test.zip");
        Enumeration e = zf.entries();
        while(e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry)e.nextElement();
            System.out.println("File: " + ze2);
// ... and extract the data as before
        }*/
    }
}


