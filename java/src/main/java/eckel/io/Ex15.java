/**
 * Exercise 15: (4) Look up DataOutputStream and DataInputStream in the JDK
 * documentation. Starting with StoringAndRecoveringData.java, create a program that
 * stores and then retrieves all the different possible types provided by the
 * DataOutputStream and DataInputStream classes. Verify that the values are stored and
 * retrieved accurately.
 */
package eckel.io;
import java.io.*;
//import jssc.SerialPort;

public class Ex15 {
}
class StoringAndRecoveringData {
    public static void main(String[] args)
            throws IOException {
        String path="C:\\users\\m.gladikov\\desktop\\files\\newFile.txt";
        File newFile=new File("C:\\users\\m.gladikov\\desktop\\files\\newFile.txt");

        byte b=89;
        char c;
        byte[] arrOfByte={65,66,67,68,69};
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(path)));
        //write****************************
        System.out.println("Initial out.size() = " + out.size());
        byte[] ba = {0,1,2,3};
        // Store first 3 bytes of byte[] ba:
        out.write(ba,0,3);
        // Store all 4 bytes in byte[] ba:
        out.write(ba);
        out.write((int)255); // Stores the lower 8 bits of int
        out.writeBoolean(true);
        out.writeByte((int)1000000);
        out.writeBytes((String)"hi");
        out.writeChar(120);
        out.writeChars("hi");
        out.writeDouble(3.14159);
        out.writeFloat(2.1f);
        out.writeInt(1057);
        out.writeLong(123456789L);
        out.writeShort(123);
        out.writeUTF("Nice piece of work");
        System.out.println("After writing, out.size() = " + out.size());
        out.close();
        System.out.println("Reading:");
        out.close();

        DataInputStream in = new DataInputStream(
        new BufferedInputStream(
                new FileInputStream(path)));
        byte[] baIn = new byte[3];
        System.out.println("bytes read by in.read(baIn, 0, 3) = " + in.read(baIn, 0, 3));
        System.out.print("baIn = ");
        for(int i = 0; i < baIn.length; i++)
            System.out.print(baIn[i] + " ");
        System.out.println();
        // Read next 4 bytes as int:
        System.out.println("in.readInt() = " + in.readInt());
        System.out.println("in.read() = " + in.read());
        System.out.println("in.readBoolean() = " + in.readBoolean());
        System.out.println("in.readByte() = " + in.readByte());
        System.out.println("in.read() = " + in.read()); // ASCII h = 104
        System.out.println("in.read() = " + in.read()); // ASCII i = 105
        System.out.println("in.readChar() = " + in.readChar());
        System.out.println("in.readChar() = " + in.readChar());
        System.out.println("in.readChar() = " + in.readChar());
        System.out.println("in.readDouble() = " + in.readDouble());
        System.out.println("in.readFloat() = " + in.readFloat());
        System.out.println("in.readInt() = " + in.readInt());
        System.out.println("in.readLong() = " + in.readLong());
        System.out.println("in.readShort() = " + in.readShort());
        System.out.println("in.readUTF() = " + in.readUTF());
    }
}