/**
 * Exercise 16: (2) Look up RandomAccessFile in the JDK documentation. Starting with
 * UsingRandomAccessFile.java, create a program that stores and then retrieves all the
 * different possible types provided by the RandomAccessFile class. Verify that the values
 * are stored and retrieved accurately.
 *//*

package eckel.io;


import java.io.*;

public class Ex16 {
    static File file=new File("c:\\users\\m.gladikov\\desktop\\files\\data.dat");

    public static void main(String[] args) throws IOException {
        if(!file.exists())
                 file.createNewFile();
        RandomAccessFile raf=new RandomAccessFile(file.getAbsolutePath(),"rw");
        for (int i = 0; i <10 ; i++)
            raf.writeInt(i);
        raf.close();

        RandomAccessFile rf=new RandomAccessFile(file.getAbsolutePath(),"rw");
        while(rf.read()!=null)
        rf.seek(2*8);
        System.out.println(rf.readDouble());;

  }
}



class UsingRandomAccessFile {
    static String file = "C:\\users\\m.gladikov\\desktop\\files\\newFile.txt";

    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for(int i = 0; i < 7; i++)
            System.out.println(
                    "Value " + i + ": " + rf.readDouble());
        System.out.println(rf.readUTF());
        rf.close();
    }
    public static void main(String[] args)
            throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for(int i = 0; i < 7; i++)
            rf.writeDouble(i*1.414);
        rf.writeUTF("The end of the file");
        rf.close();

        display();
        rf = new RandomAccessFile(file, "rw");
        rf.seek(5*8);
        rf.writeDouble(47.0001);
        rf.close();
        display();
    }
}*/
