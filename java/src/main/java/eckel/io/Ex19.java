/**
 * Exercise 19: (2) Using BinaryFile and a Map<Byte,Integer>, create a program that
 * counts the occurrence of all the different bytes in a file.
 */
package eckel.io;

import java.io.*;
import java.util.*;

public class Ex19 {
    static Map<Byte,Integer> countBytes(String path) throws IOException {

        byte[] bytes=BinaryFile.read(path);
        List<Byte> list=new ArrayList();
        for(byte b:bytes) list.add(b);
        Map<Byte,Integer> map=new HashMap<>();
        for(Byte item:list){
            Integer count=map.get(item);
            map.put(item,count==null?1:count+1);
        }
        return map;
    }
    public static void main(String[] args) throws IOException {
        String path="D:\\dev\\files\\text.txt";
       System.out.println(new MapWrapper(countBytes("D:\\dev\\files\\word.doc")).toString());
        /*Byte[] bytes={0,1,2,3,4,5};
        for(Byte b:bytes)
            System.out.println(String.format("%8s",Integer.toBinaryString(b & 0xFF)).replace(' ','0'));*/
    }
}
class MapWrapper{
    private Map<Byte,Integer> map;
    private StringBuilder sb=new StringBuilder();
    public MapWrapper(Map<Byte,Integer> map){
        this.map=map;
        for(Map.Entry<Byte,Integer> entry:map.entrySet())
            sb.append(String.format("%8s",Integer.toBinaryString(entry.getKey()&0xFF).replace(' ','0'))+
                    "  -  "+entry.getValue()+'\n');
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}

class BinaryFile {
    public static byte[] read(File bFile) throws IOException {
        BufferedInputStream bf = new BufferedInputStream(
                new FileInputStream(bFile));
        try {
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        } finally {
            bf.close();
        }
    }
    public static byte[]
    read(String bFile) throws IOException {
        return read(new File(bFile).getAbsoluteFile());
    }
}
