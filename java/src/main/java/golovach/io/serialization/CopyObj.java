package golovach.io.serialization;

import java.io.*;

public class CopyObj {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream buff=new ByteArrayOutputStream();
        ObjectOutputStream out=new ObjectOutputStream(buff);
        String s="Hello!";
        out.writeObject(s);
        byte[] rawBytes=buff.toByteArray();
        ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(rawBytes));
        System.out.println((String)in.readObject());
    }
}
