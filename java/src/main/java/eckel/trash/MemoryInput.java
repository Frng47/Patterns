package eckel.trash;
import java.io.*;
public class MemoryInput {
    public static void main(String[] args)
            throws IOException {
        StringReader in = new StringReader(
                BufferedInputFile.read("C:\\users\\m.gladikov\\desktop\\files\\text.txt"));
        int c;
        while((c = in.read()) != -1)
            System.out.print((char)c);
    }
} /* (Execute to see output) *///:~
class FormattedMemoryInput {
    public static void main(String[] args)
            throws IOException {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read(
                                    "C:\\users\\m.gladikov\\desktop\\files\\text.txt").getBytes()));
            while(true)
                System.out.print((char)in.readByte());
        } catch(EOFException e) {
            System.err.println("End of stream");
        }
    }
}

class BasicFileOutput {
    static String file_1 = "C:\\users\\m.gladikov\\desktop\\files\\text.txt";
    static String file_2 = "C:\\users\\m.gladikov\\desktop\\files\\text_2.txt";
    public static void main(String[] args)
            throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read(file_1)));
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(file_2)));
        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null )
            out.println(lineCount++ + ": " + s);
        out.close();
// Show the stored file:
        System.out.println(BufferedInputFile.read(file_2));
    }
} /* (Execute to see output) *///:~