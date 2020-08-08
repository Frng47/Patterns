package eckel.io;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

public class Zip{
    private static String SOURCE="D:\\dev\\files\\src.txt";
    private static String DST="D:\\dev\\files\\gzip.gz";
    public static void main(String[] args) throws IOException {
        BufferedReader in=
                new BufferedReader(new FileReader(SOURCE));
        BufferedOutputStream out=
                new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(DST)));
        int c;
        while((c = in.read()) != -1)
            out.write(c);
        in.close();
        out.close();
        System.out.println("Reading file");
        BufferedReader in2 = new BufferedReader(
                new InputStreamReader(new GZIPInputStream(
                        new FileInputStream("D:\\dev\\files\\gzip.gz"))));
        String s;
        while((s = in2.readLine()) != null)
            System.out.println(s);
    }
}
class MultiFileStorage{
    public static void main(String[] args)
            throws IOException {
        String[] files={"D:\\dev\\files\\0.txt","D:\\dev\\files\\1.txt","D:\\dev\\files\\2.txt"};
        FileOutputStream f = new FileOutputStream("D:\\dev\\files\\test.zip");
        CheckedOutputStream csum =
                new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out =
                new BufferedOutputStream(zos);
        zos.setComment("A test of Java Zipping");
// No corresponding getComment(), though.
        for(String arg : files) {
            System.out.println("Writing file " + arg);
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
// Now extract the files:
        System.out.println("Reading file");
        FileInputStream fi = new FileInputStream("D:\\dev\\files\\test.zip");
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
        ZipFile zf = new ZipFile("D:\\dev\\files\\test.zip");
        Enumeration e = zf.entries();
        while(e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry)e.nextElement();
            System.out.println("File: " + ze2);
// ... and extract the data as before
        }
        /* if(args.length == 1) */
    }
}


