/**
 * Exercise 27: (1) Create a Serializable class containing a reference to an object of a
 * second Serializable class. Create an instance of your class, serialize it to disk, then restore it
 * and verify that the process worked correctly.
 */
package eckel.io;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import sun.text.normalizer.UTF16;

import java.io.*;
import java.nio.file.Files;
import java.util.Random;

public class Ex27 implements Serializable {
    SecondSerializableClass second=new SecondSerializableClass();

    public static void main(String[] args) throws IOException {

        ObjectOutputStream ous=new ObjectOutputStream(new FileOutputStream("D:\\dev\\files\\Ex27.obj"));
        ous.writeObject(new Ex27());
    }


}
class OpenObj{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("D:\\dev\\files\\Ex27.obj"));
         Ex27 obj=(Ex27)ois.readObject();
        System.out.println(obj.second.i);;
    }


}
class SecondSerializableClass implements Serializable{
    public  int i=5;
    public static Random random=new Random();
    public SecondSerializableClass(){
        i=random.nextInt(10);
    }


}
class OpenDB{
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new FileReader("D:\\dev\\files\\1.db"));
       StringBuilder sb=new StringBuilder();
       DataInputStream inData=new DataInputStream(new BufferedInputStream(new FileInputStream("D:\\dev\\files\\1.db")));
        byte[] fileContent = Files.readAllBytes(new File("D:\\dev\\files\\1.db").toPath());

           System.out.println(new String(fileContent,"Big5"));

       // System.out.println(new String(bytes,"UTF-16"));

    }
}