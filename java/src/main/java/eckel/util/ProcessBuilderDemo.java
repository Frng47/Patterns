package eckel.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class ProcessBuilderDemo {
    public static void main(String[] args) throws IOException {
        Process process=new ProcessBuilder("java","-version").start();
        //List<String> results=readOutput();
        ProcessBuilder processBuilder=new ProcessBuilder();
        Map<String,String> environment=processBuilder.environment();
        environment.forEach((key,value)-> System.out.println(key+": "+value));
        //System.out.println(;);
    }
}
class Ping{
    public static void main(String[] args) {
        ProcessBuilder processBuilder=new ProcessBuilder();
        processBuilder.command("cmd.exe","/c","ping -n 3 197.0.0.1");
        try{
            Process process=processBuilder.start();
            BufferedReader reader=new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line=reader.readLine())!=null)
                System.out.println(line);
            int exitCode=process.waitFor();
            System.out.println("\nExited with error code: "+exitCode);
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class SysProp{
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
    }
}

