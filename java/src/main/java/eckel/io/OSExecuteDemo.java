package eckel.io;
import java.io.*;

public class OSExecuteDemo {
    public static void main(String[] args) throws IOException {
        OSExecute.command("cmd.exe /c d:\\dev\\Files\\text.txt");
       // OSExecute.command("cmd.exe /c d:\\dev\\file\\text.txt");
        //Process process=new ProcessBuilder("D:\\dev\\files\\text.txt").start();
        //Process process=new ProcessBuilder("cmd.exe","/c","dir C:\\users").start();
        //Process process=new ProcessBuilder("cmd.exe","/c","d:\\dev\\files\\text.txt").start();
    }
// Run an operating system command


} /* Output:
Compiled from "OSExecuteDemo.java"
public class OSExecuteDemo extends java.lang.Object{
678 Thinking in Java Bruce Eckel
public OSExecuteDemo();
public static void main(java.lang.String[]);
}*/
class OSExecuteException extends RuntimeException {
public OSExecuteException(String why) { super(why); }
}
