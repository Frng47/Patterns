/**
 * Exercise 20: (4) Using Directory.walk( ) and BinaryFile, verify that all .class files
 * in a directory tree begin with the hex characters ‘CAFEBABE’.
 */
package eckel.io;

import eckel.util.io.DirInfo;

import java.io.*;

public class Ex20 {
   static boolean verify(String path) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(path));
        try {
            byte[] data = new byte[in.available()];
            in.read(data);
            StringBuilder result=new StringBuilder();
            for (int i = 0; i <4 ; i++) {
                result.append(String.format("%x",data[i]));
            }
            return result.toString().equalsIgnoreCase("cafebabe");
        } finally {
            in.close();
        }
    }
    public static void main(String[] args) throws IOException {
        String path="d:\\dev\\Idea\\Arduino\\target\\classes";
        String regex=".*.class$";
        DirInfo.TreeInfo tree=DirInfo.walk(path,regex);
        for(File item:tree.files)
            System.out.println(item.getName()+" - "+verify(item.getAbsolutePath()));
        //System.out.println(verify("d:\\dev\\Files\\main.class"));
    }
}
