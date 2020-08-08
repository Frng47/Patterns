package golovach.io;

public class Binary {
    public static void main(String[] args) {
        int i=0b11111111_11100011_10001001_10000001;
        byte b0=(byte)i;
        byte b1=(byte)(i>>8);
        byte b2=(byte)(i>>16);
        byte b3=(byte)(i>>24);
        //System.out.println(b0);

        System.out.println(Integer.toBinaryString(b0&0xFF));
        System.out.println(Integer.toBinaryString(b1&0xFF));
        System.out.println(Integer.toBinaryString(b2&0xFF));
        System.out.println(Integer.toBinaryString(b3&0xFF));
    }
}
