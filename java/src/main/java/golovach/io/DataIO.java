package golovach.io;

import java.io.*;

public class DataIO {
    public static void main(String[] args) throws IOException {

        DataOutputStream out=new DataOutputStream(new FileOutputStream("d:\\dev\\tmp\\data.txt"));
        out.writeDouble(5.1);
        out.writeUTF("this is a double");
        DataInputStream in=new DataInputStream(new FileInputStream("d:\\dev\\tmp\\data.txt"));
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());

    }
}
