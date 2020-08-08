package eckel.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Ex24 {
final static int BSIZE=1024;

    public static void main(String[] args) {
        ByteBuffer bb= ByteBuffer.allocate(BSIZE);
        IntBuffer ib=bb.asIntBuffer();
        ib.put(new int[]{0,1,2,3,5,6});
        //System.out.println(ib.get(3));
        ib.put(3,666);
        //System.out.println(ib.get(3));
        ib.flip();
        while(ib.hasRemaining()) {
            int i = ib.get();
            System.out.println(i);

        }
    }
}

class UsingBuffers {
    private static void symmetricScramble(CharBuffer buffer){
        while(buffer.hasRemaining()) {
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();
            buffer.put(c2).put(c1);
        }
    }
    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        System.out.println(cb.rewind());
        symmetricScramble(cb);
        System.out.println(cb.rewind());
        /*symmetricScramble(cb);
        System.out.println(cb.rewind());*/
    }
}
