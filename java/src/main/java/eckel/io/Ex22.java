/**
 * Exercise 22: (5) Modify OSExecute.java so that, instead of printing the standard
 * output stream, it returns the results of executing the program as a List of Strings.
 * Demonstrate the use of this new version of the utility.
 */
package eckel.io;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ex22 {

}
//: io/Redirecting.java
// Demonstrates standard I/O redirection.
class Redirecting {
    public static void main(String[] args)
            throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("D:\\dev\\files\\dest.txt"));
        PrintStream out = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream("D:\\dev\\files\\text.txt")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null)
            System.out.println(s);
        out.close(); // Remember this!
        System.setOut(console);
    }
} ///:~
class Redir2{

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream   out = new PrintStream(new BufferedOutputStream(new FileOutputStream("D:\\dev\\files\\text.txt")));
        System.setOut(out);
        System.setErr(out);
        System.out.println("hello");
        System.err.println("hello");
    }

}
class RRRRRRRRR{
    public static void main(String[] args) {
        //System.out.println(System.getProperties());
        System.out.println(System.getProperty("user.dir"));
    }
}
class OSExecuteInList{

    static List<String> command(String command){
         Boolean err=false;
        List<String> result=new ArrayList<>();
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader in=
                    new BufferedReader(new InputStreamReader(process.getInputStream()));
            try {
                String s;
                while ((s=in.readLine()) != null){
                    System.out.println(s);
                    result.add(s);}
            }finally {
                in.close();
            }

        BufferedReader error=
                new BufferedReader(new InputStreamReader(process.getErrorStream())) ;
            while (error.readLine()!=null){
                System.out.println(error.readLine());
                err=true;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        if(err) throw new OSExecuteException("Errors executing "+command);
        return result;
    }
//demo
    public static void main(String[] args) {
        System.out.println(command("cmd.exe /c ping -n 3 197.0.0.1"));
        //command("\"cmd.exe /c d:\\\\dev\\\\Files\\\\text.txt\"");
    }
}
