/**
 * Exercise 17: (4) Using TextFile and a Map<Character,Integer>, create a program
 * that counts the occurrence of all the different characters in a file. (So if there are 12
 * occurrences of the letter ‘a’ in the file, the Integer associated with the Character
 * containing ‘a’ in the Map contains ‘12’).
 */
package eckel.io;
import java.io.*;
import java.util.*;

public class Ex17 {
    String path="D:\\dev\\files\\Dest.txt";
    public static Map<Character,Integer> countCharInText(String path){
        Map<Character,Integer> map=new HashMap<>();
        String s=textFileReader(path);
        char[] chars= s.toCharArray();
        List<Character> characters=new ArrayList<>();
        for(char item:chars){
            characters.add(item);
        }
        for(Character item:characters){
            if (map.containsKey(item)) {
                int count=map.get(item)+1;
                map.put(item, count);
            } else {
                map.put(item, 1);
            }
        }
        return map;
    }
    static String textFileReader(String path)  {
        StringBuilder sb=new StringBuilder();
        String s;
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            try {
                while ((s = in.readLine()) != null) {
                    sb.append(s + "\n");
                }
            }finally {
                in.close();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String path="d:\\dev\\files\\origin.txt";
        System.out.println(countCharInText(path));
    }
}
class TextFile extends ArrayList<String> {
    // Read a file as a single string:
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in= new BufferedReader(new FileReader(
                    new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
    // Write a single file in one method call:
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    // Read a file, split by any regular expression:
    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
// Regular expression split() often leaves an empty
// String at the first position:
        if(get(0).equals("")) remove(0);
    }
    // Normally read by lines:
    public TextFile(String fileName) {
        this(fileName, "\n");
    }
    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try {
                for(String item : this)
                    out.println(item);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    // Simple test:
    public static void main(String[] args) {
        //System.out.println(new File("D:\\dev\\files\\Origin.txt").exists());
        String pathDest="D:\\dev\\files\\Dest.txt";
        String pathOrigin="D:\\dev\\files\\Origin.txt";
        String file = read(pathOrigin);
        write(pathDest, file);
        TextFile text = new TextFile(pathOrigin);
        text.write(pathDest);
// Break into unique sorted list of words:
        TreeSet<String> words = new TreeSet<String>(
                new TextFile("TextFile.java", "\\W+"));
// Display the capitalized words:
        System.out.println(words.headSet("a"));
    }
}
class Test1{
    public static void main(String[] args) {
        String path="D:\\dev\\files\\text.txt";
        System.out.println(new File(path).getAbsolutePath());
    }
}