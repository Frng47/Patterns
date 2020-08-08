package golovach.io;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CodeSet {
    static String printBytes(byte[] bytes){
        StringBuilder sb=new StringBuilder();
        for(byte b:bytes)
            sb.append(new Byte(b)+" ");
        return sb.toString();
    }
    static void testCodeSet(String data,String[] codeSets){
        for (String setItem:codeSets) {
            try {
                byte[] bytes = data.getBytes(setItem);
                System.out.print(setItem + '\t' + Arrays.toString(bytes)+'\t'+ bytes.length+'\n');
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        String[] codeSets={"ASCII","latin1","UTF-8","UTF-16","UTF-16LE","UTF-16BE","UTF-32LE","UTF-32BE","UNICODE"};
           String     data="а";
          // testCodeSet(data,codeSets);
      /*  char ch=0x0001;
        System.out.println(Arrays.toString((""+ch).getBytes("UTF-8")));
        ch=0x0011;
        System.out.println(Arrays.toString((""+ch).getBytes("UTF-8")));
        ch=0x0111;
        System.out.println(Arrays.toString((""+ch).getBytes("UTF-8")));
        ch=0x1111;
        System.out.println(Arrays.toString((""+ch).getBytes("UTF-8")));*/
      char c=0b1011111;//binary
//        System.out.println(c);
        byte[] bytes="abc".getBytes("UTF-8");
        System.out.println(new String(bytes,"UTF-8"));
    }
}
