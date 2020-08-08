/**
 * Exercise 9: (1) Modify Exercise 8 to force all the lines in the LinkedList to uppercase
 * and send the results to System.out.
 */
package eckel.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Ex9 {
    static void readAndReversAndPrint(String[] paths){
        LinkedList<String> list=new LinkedList<>();
        String s;
        StringBuilder sb=new StringBuilder();
        if(paths.length==0)
            System.out.println("Enter args");
        for(String path:paths){
            try{
                BufferedReader in=new BufferedReader(new FileReader(path));
                try{
                    while((s=in.readLine())!=null)
                    list.add(s);
                while (list.peekLast()!=null)
                    sb.append(list.pollLast()+"\n");
                }finally {
                    in.close();
                }
            }catch (IOException e){
                System.err.println(e.getMessage());
            }
            System.out.println((sb.toString()).toUpperCase());
            sb.delete(0,sb.length());
                    }
    }

    public static void main(String[] args) {
        readAndReversAndPrint(args);
    }
}
