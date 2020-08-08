package golovach.io.filters.oop;



import java.io.*;
import java.util.Arrays;

public class ZeroByteFilterOOP {
    public static void filter(InputStream in, OutputStream out, int buffSize) throws IOException{
        byte[] buff=new byte[buffSize];
        int count;
        while((count=in.read(buff))!=-1){
            State state=new Zero(out,buff);
            for (int i = 0; i < count; i++) {
                state=state.next(buff[i]);
            }
            state.finish();
        }
    }

    public static void main(String[] args) {
        byte[] bytes={0b1,0b1,0b0,0b1,0b0,0b1,0b0,0b1};
        byte[] bytesFiltered=new byte[10];
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            filter(new ByteArrayInputStream(bytes),out,5);
            bytesFiltered=out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.asList(bytesFiltered));
    }

}


