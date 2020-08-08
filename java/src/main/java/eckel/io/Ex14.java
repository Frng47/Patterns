/**
 * Exercise 14: (2) Starting with BasicFileOutput.java, write a program that compares
 * the performance of writing to a file when using buffered and unbuffered I/O.
 */
package eckel.io;
import eckel.trash.BufferedInputFile;

import java.io.*;
import java.util.PriorityQueue;

public class Ex14 {
    private static String readFile="C:\\users\\m.gladikov\\desktop\\files\\read.txt";
    private static String writeFile="C:\\users\\m.gladikov\\desktop\\files\\write.txt";
    static void millionChars(String path){
        int rawSize=100;
        int columnSize=10000;
        char c='0';
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <rawSize; i++) {
            sb.append(c);
        }
        PrintWriter out;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(path)));
            try {
                for (int i = 0; i < columnSize; i++) {
                    out.println(sb.toString());
                }
            }finally {
                out.close();
            }
        }catch (IOException e){e.getMessage();}

    }
    static String bReadWrite(){
        Long startTime=System.nanoTime();
        //***********************
        PriorityQueue<String> queue=new PriorityQueue<>();
        String s;
        try{
            BufferedReader in=new BufferedReader(new FileReader(readFile));
            try{
             while((s=in.readLine())!=null)
                 queue.add(s);
            }finally {
                in.close();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(writeFile)));
           try{ while (queue.size()>0)
                out.println(queue.poll());}finally {
               out.close();
           }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        //***********************
        Long stopTime=System.nanoTime();
        double result=Math.round((double) (stopTime-startTime)/1000000000);//execution time in seconds
        StringBuilder sb=new StringBuilder();
        sb.append("buffered writing duration: "+result+" sec");
        return sb.toString();
    }
    static String unbReadWrite(){
        Long startTime=System.nanoTime();
        //***********************
        PriorityQueue<String> queue=new PriorityQueue<>();
        String s;
        try{
            BufferedReader in=new BufferedReader(new FileReader(readFile));
            try{
                while((s=in.readLine())!=null)
                    queue.add(s);
            }finally {
                in.close();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        try {
            PrintWriter out = new PrintWriter(new FileWriter(writeFile));
            try{ while (queue.size()>0)
                out.println(queue.poll());}finally {
                out.close();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        //***********************
        Long stopTime=System.nanoTime();
        double result=Math.round((double) (stopTime-startTime)/1000000000);//execution time in seconds
        StringBuilder sb=new StringBuilder();
        sb.append("unbuffered writing duration: "+result+" sec");
        return sb.toString();
    }
public static void main(String[] args) {
    //millionChars(readFile);
    System.out.println(bReadWrite());
    System.out.println(unbReadWrite());
    }
}
