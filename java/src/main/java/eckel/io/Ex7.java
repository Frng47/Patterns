/**
 * Exercise 7: (2) Open a text file so that you can read the file one line at a time. Read each
 * line as a String and place that String object into a LinkedList. Print all of the lines in the
 * LinkedList in reverse order.a
 */
package eckel.io;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Ex7 {
    static String read(String filePath) throws IOException {
        BufferedReader in=new BufferedReader(
                new FileReader(filePath));
        String s;
        StringBuilder sb=new StringBuilder();
        while((s=in.readLine())!=null)
            sb.append(s+"\n");
        in.close();
        return sb.toString();
    }
    static List<String> readToList(String filePath, LinkedList<String> list) throws IOException {
        String s;
        BufferedReader in=new BufferedReader(
                new FileReader(filePath));
        while((s=in.readLine())!=null)
            list.add(s);
            in.close();
        return list;
    }
    static void printList(List<String> list){
       ListIterator iterator=list.listIterator(list.size());
        while (iterator.hasPrevious()){
            System.out.println(list.get(iterator.previousIndex()));
            iterator.previous();
        }
    }

    public static void main(String[] args) {
        String path="C:\\users\\m.gladikov\\Desktop\\Files\\text.txt";
        LinkedList<String> list=new LinkedList<>();
        while(true){
            System.out.print("Enter a path:");
            try{
                printList(readToList(path,list));
            }catch (IOException e){
                System.err.println(e.getMessage());
            }
        }


    }
}
