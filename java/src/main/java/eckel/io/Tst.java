package eckel.io;

import java.io.*;
import java.util.zip.*;

public class Tst {
    public static void main(String[] args) throws IOException {
        String[] files={"D:\\dev\\files\\0.txt","D:\\dev\\files\\1.txt","D:\\dev\\files\\2.txt"};
        CheckedOutputStream cs=new CheckedOutputStream(
                new FileOutputStream("D:\\dev\\files\\container.zip"),new Adler32());
         ZipOutputStream zos=
              new ZipOutputStream(cs);
         BufferedOutputStream out=new BufferedOutputStream(zos);
        for(String arg:files){
            BufferedReader in=
                    new BufferedReader(new FileReader(arg));

            zos.putNextEntry(new ZipEntry(arg));
            int c;
            while ((c=in.read())!=-1)
                out.write(c);
            in.close();
            out.flush();
        }
        out.close();
        System.out.println("Checksum="+cs.getChecksum().getValue());
//reading
        System.out.println("Reading");
        FileInputStream fi=
                new FileInputStream("D:\\dev\\files\\container.zip");
        CheckedInputStream csumi=
                new CheckedInputStream(fi,new Adler32());
        ZipInputStream in2=
                new ZipInputStream(csumi);
        BufferedInputStream bis=
                new BufferedInputStream(in2);
        ZipEntry ze;
        while ((ze=in2.getNextEntry())!=null) {
            System.out.println("Reading file " + ze);
            int x;
            while ((x = bis.read()) != -1)
                System.out.write(x);
        }
    }
}
