package eckel.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class Ex8 {
    static String readAndReverse(String path) {
        LinkedList<String> list=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        String s;
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            while((s=in.readLine())!=null)
                list.add(s);
            while(list.peekLast()!=null)
                sb.append(list.pollLast()+"\n");
        }catch (IOException e){
            System.err.println(e.getMessage());}

        return sb.toString();
    }
    public static void main(String[] args) {
        //System.out.println(readAndReverse(args[0]));;
        String[] arr={"1","2","3"};
        LinkedList<String> list=new LinkedList<>(Arrays.asList(arr));
        System.out.println();
    }
}
