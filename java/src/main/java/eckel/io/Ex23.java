/**
 * Exercise 23: (6) Create and test a utility method to print the contents of a CharBuffer
 * up to the point where the characters are no longer printable.
 */
package eckel.io;

import com.sun.javaws.IconUtil;

import java.nio.*;
import java.nio.channels.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;

public class Ex23{
  static  boolean isPrintable(char c){
        return ((c>='!')&&(c<=126))?true:false;
    }
    static void printCharBuffer(CharBuffer cb){
        cb.clear();
        char c;
        while (cb.hasRemaining()){
            c=cb.get();
            if(!(isPrintable(c)))
                continue;
            System.out.println(c);
        };
    }
    public static void main(String[] args) {
        char[] ca={'a','b','c','d'};
        CharBuffer cb=CharBuffer.wrap(ca);
        //printCharBuffer(cb);
        char[] ca2={'a','b','c','d','e'};
        CharBuffer cb2=CharBuffer.allocate(6);
        cb2.put(ca2);
        //printCharBuffer(cb2);
        //unprintable set
        char[] ca3={(char)0x1,(char)0x7,(char)0x3,'a','b'};
        CharBuffer cb3=CharBuffer.allocate(6);
        cb3.put(ca3);
        printCharBuffer(cb3);
    }
}
class Ex23_ {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws IOException{
       /* FileChannel fc=new FileOutputStream("D:\\dev\\Files\\text.txt").getChannel();
        fc.write(ByteBuffer.wrap("Putin xyilo".getBytes()));
        fc.close();
        fc=new FileInputStream("D:\\dev\\Files\\text.txt").getChannel();
        ByteBuffer buff=ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining())
            System.out.print((char)buff.get());
        String [] arr={"d:\\dev\\files\\source.txt","d:\\dev\\files\\dest.txt"};
        CopyChanel.main(arr);*/
       FileChannel fc
               =new FileInputStream("d:\\dev\\files\\dest.txt").getChannel();
       ByteBuffer buffer=ByteBuffer.allocate(1024);
        // Decode using this system’s default Charset:
       fc.read(buffer);
       buffer.flip();
       buffer.rewind();
       String encoding=System.getProperty("file.encoding");
       System.out.println("Decoded using " + encoding + ": "
               + Charset.forName(encoding).decode(buffer));
        // Or, we could encode with something that will print:
        fc=new FileOutputStream("d:\\dev\\files\\dest.txt").getChannel();
        fc.write(ByteBuffer.wrap("some text".getBytes("UTF-8")));
        fc.close();
        // Now try reading again:
        fc=new FileInputStream("d:\\dev\\files\\dest.txt").getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());

    }
}
//: io/GetChannel.java
// Getting channels from streams
class CopyChanel{
    public static final int BSIZE=1024;
    public static void main(String[] args) throws IOException{
        if(args.length!=2){
            System.out.println("illegal args");
            System.exit(1);
        }
        FileChannel
                in=new FileInputStream(args[0]).getChannel(),
                out=new FileOutputStream(args[1]).getChannel();
        ByteBuffer buffer=ByteBuffer.allocate(BSIZE);
        while (in.read(buffer)!=-1){
            buffer.flip();//prepare for writing
            out.write(buffer);
            buffer.clear();//prepare for reading
        }
    }
}
class GetChannel {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception {
// Write a file:
        FileChannel fc =
                new FileOutputStream("D:\\dev\\Files\\text.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();
// Add to the end of the file:
        fc =
                new RandomAccessFile("D:\\dev\\Files\\text.txt", "rw").getChannel();
        fc.position(fc.size()); // Move to the end
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();
// Read the file:
        fc = new FileInputStream("D:\\dev\\Files\\text.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while(buff.hasRemaining())
            System.out.print((char)buff.get());
    }
} /* Output:
Some text Some more
*///:~
class TransferTo {
    public static void main(String[] args) throws Exception {
        if(args.length != 2) {
            System.out.println("arguments: sourcefile destfile");
            System.exit(1);
        }
        FileChannel
                in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        in.transferTo(0, in.size(), out);
// Or:
// out.transferFrom(in, 0, in.size());
    }
}

class BufferToText {
    private static final int BSIZE = 1024;
    public static void main(String[] args) throws Exception {
        FileChannel fc =
                new FileOutputStream("D:\\dev\\Files\\text.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();
        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
// Doesn’t work:
        System.out.println(buff.asCharBuffer());
// Decode using this system’s default Charset:
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + ": "
                + Charset.forName(encoding).decode(buff));
// Or, we could encode with something that will print:
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap(
                "Some text".getBytes("UTF-16BE")));
        fc.close();
// Now try reading again:
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
// Use a CharBuffer to write through:
        fc = new FileOutputStream("data2.txt").getChannel();
        buff = ByteBuffer.allocate(24); // More than needed
        buff.asCharBuffer().put("Some text");
        fc.write(buff);
        fc.close();
// Read and display:
        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
    }
}
class AvailableCharSets {
    public static void main(String[] args) {
        SortedMap<String,Charset> charSets =
                Charset.availableCharsets();
        Iterator<String> it = charSets.keySet().iterator();
        while(it.hasNext()) {
            String csName = it.next();
            System.out.print(csName);
            Iterator aliases =
                    charSets.get(csName).aliases().iterator();
            if(aliases.hasNext())
                System.out.print(": ");
            while(aliases.hasNext()) {
                System.out.print(aliases.next());
                if(aliases.hasNext())
                    System.out.print(", ");
            }
            System.out.println();
        }
    }
}
class ByteBuff{


    public static void main(String[] args) {
        ByteBuffer bb=ByteBuffer.allocate(1024);
        //int i=0;
        /*while (i++<bb.limit())
            System.out.println(i+" "+bb.get());*/
        bb.asCharBuffer().put("howdy");
        char c;
        while((c=(char)bb.getChar())!=0)
            System.out.println(c+" ");
        bb.asShortBuffer().put((short)66666);
        System.out.println(bb.getShort());
        bb.rewind();

    }
}