package golovach.io;

import org.omg.CORBA.ByteHolder;

import java.io.*;

public class FileByteCopy {
    public static byte[] readFile(File file) throws IOException {
        byte[] bytes=new byte[(int)file.length()];
        FileInputStream in=new FileInputStream(file);
        in.read(bytes);
        in.close();
        return bytes;
    }


    public static void main(String[] args) throws IOException {
        File file=new File("D:\\dev\\files\\1.db");
        BytesHolder holder=new BytesHolder(file);
        System.out.println(holder.toString());


    }
}

class BytesHolder{
    private byte[] bytes;
    public  BytesHolder(File file) throws IOException {
        bytes=readFile(file);
    }
    private static byte[] readFile(File file) throws IOException {
        byte[] bytes=new byte[(int)file.length()];
        FileInputStream in=new FileInputStream(file);
        in.read(bytes);
        in.close();
        return bytes;
    }
    public String toString(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<bytes.length;i++){
            if(i%8==0)
                sb.append("\n");

                int val = bytes[i];
                for (int j = 0; j < 8; j++)
                {
                    sb.append((val & 128) == 0 ? 0 : 1);
                    val <<= 1;
                }
               sb.append(' ');
            }

        return sb.toString();
    }


}
