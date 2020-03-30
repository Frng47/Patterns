package io;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class RowBytes {
    public static void main(String[] args) throws UnsupportedEncodingException {
       /* byte[] bytes={70,71,72};
        String str=new String(bytes,"UTF-8");
        System.out.println(str);
        char[] chars=str.toCharArray();
        System.out.println(str.toCharArray().toString());
        System.out.println((int)chars[0]);
        System.out.println((byte)chars[1]);
        System.out.println(chars[2]);*/
//        testCodePoint(165_265);

        int a=0x20;//literal hexadecimal
        int b=010;//literal octal
        int c=0b10;//literal binary
        String str="\uFFFF";//unicode literal
        System.out.println(str);
//        String str2 = new String(bytes[],"UTF-8");  text Recoding(take byte[] from string.getBytes)
    }
    private static void testCodePoint(int codePoint){
        char[] charArray=Character.toChars(codePoint);
        System.out.println("char []: "+ Arrays.toString(charArray));
        String str=new String(charArray);
        System.out.println("String: "+str);
        System.out.println("String length: "+str.length());
        System.out.println("String codePointCount: "+str.codePointCount(1,str.length()));


    }
}
