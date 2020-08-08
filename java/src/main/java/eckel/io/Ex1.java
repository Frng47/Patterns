package eckel.io;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Ex1 {
        public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if(args.length == 0){
            list = path.list();
            System.out.println("HELLO");
           System.out.println(list);}
        else
        list = path.list(new DirFilter(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem);
    }
}

class DirFilter implements FilenameFilter {
    private Pattern pattern;
    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}


