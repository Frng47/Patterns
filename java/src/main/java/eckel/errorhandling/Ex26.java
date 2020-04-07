package eckel.errorhandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex26 {

    public static void main(String[] args) throws IOException {
            FileInputStream file = new FileInputStream("Ex28.java");
            file.close();
        }
    }

