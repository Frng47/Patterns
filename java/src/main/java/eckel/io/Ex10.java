/**
 * Exercise 10: (2) Modify Exercise 8 to take additional command-line arguments of words
 * to find in the file. Print all lines in which any of the words match.
 */
package eckel.io;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Ex10 {
    static List<String> readFile(String path){
        String s;
//        StringBuilder sb=new StringBuilder();
        ArrayList<String> list=new ArrayList<>();
        try{
            BufferedReader in=new BufferedReader(new FileReader(path));
            try{
                while ((s=in.readLine())!=null)
                    list.add(s);
            }finally {
                in.close();
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        return list;
    }
    static List<String> readAndMatch(String[] args){
        if(args.length<2){
            System.out.println("Enter correct data");
            System.exit(1);
        }
        ArrayList<String> listFromFile=(ArrayList<String>) readFile(args[0]);
        ArrayList<String> list=new ArrayList<>();
        for(int i=1;i<args.length;i++){
            String regex=".*"+args[i]+".*";
            Pattern pattern=Pattern.compile(regex);
            for (int j = 0; j <listFromFile.size() ; j++) {
                if(pattern.matcher(listFromFile.get(j)).matches())
                    if(!list.contains(listFromFile.get(j)))
                        list.add(listFromFile.get(j));
            }

        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(readAndMatch(args));;
    }
}
