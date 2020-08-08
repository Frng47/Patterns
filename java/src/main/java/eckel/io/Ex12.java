/**
 * Exercise 12: (3) Modify Exercise 8 to also open a text file so you can write text into it.
 * Write the lines in the LinkedList, along with line numbers (do not attempt to use the
 * "LineNumber" classes), out to the file
 */


package eckel.io;

import java.io.*;
import java.util.*;

public class Ex12 {
    private static String pathRead="C:\\users\\m.gladikov\\desktop\\files\\read.txt";
    private static String pathWrite="C:\\users\\m.gladikov\\desktop\\files\\write.txt";
    static Stack<String> read(String path) {
        Stack<String> stack=new Stack<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String s;
            try {
                while ((s = in.readLine()) != null) {
                    stack.push(s);
                }
                return stack;
            } finally {
                in.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return stack;
    }
    static void write(Stack<String> stack,String path){
        PrintWriter out= null;
        try {
            out = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(stack.size()>0)
            out.println(stack.pop());
        System.out.println(out.checkError());
    }

    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        stack=read(pathRead);
        write(stack,pathWrite);
       // System.out.println(stack.pop());
    }
}


