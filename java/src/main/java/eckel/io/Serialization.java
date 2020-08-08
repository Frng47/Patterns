package eckel.io;

import java.io.*;
import java.util.Random;

public class Serialization {}
class Worm implements Serializable{
    private static Random rand = new Random(47);
    private Data[] d = {
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10))
    };
    private Worm next;
    private char c;
    // Value of i == number of segments
    public Worm(int i, char x) {
        System.out.println("Worm constructor: " + i);
        c = x;
        if(--i > 0)
            next = new Worm(i, (char)(x + 1));
    }
    public Worm() {
        System.out.println("Default constructor");
    }
    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for(Data dat : d)
            result.append(dat);
        result.append(")");
        if(next != null)
            result.append(next);
        return result.toString();
    }
    public static void main(String[] args)
            throws ClassNotFoundException, IOException {
        Worm w = new Worm(6, 'a');
        System.out.println("w = " + w);
        ObjectOutputStream out = new ObjectOutputStream(
                                new FileOutputStream("D:\\dev\\files\\worm.out"));
        out.writeObject("Worm storage\n");
        out.writeObject(w);
        out.close(); // Also flushes output
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("D:\\dev\\files\\worm.out"));
        String s = (String)in.readObject();
        Worm w2 = (Worm)in.readObject();
        System.out.println(s + "w2 = " + w2);
        ByteArrayOutputStream bout =
                new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm storage\n");
        out2.writeObject(w);
        out2.flush();
        ObjectInputStream in2 = new ObjectInputStream(
                new ByteArrayInputStream(bout.toByteArray()));
        s = (String)in2.readObject();
        Worm w3 = (Worm)in2.readObject();
        System.out.println(s + "w3 = " + w3);
    }
}

class Data implements Serializable {
    private int n;
    public Data(int n) { this.n = n; }
    public String toString() { return Integer.toString(n); }
}

class Simple implements Serializable{
    private Integer i;
    private static Random random=new Random();
    public Simple(Integer i){
        this.i=i;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Simple ob1=new Simple(1);
        Simple ob2=new Simple(random.nextInt(10));

        ObjectOutputStream ous=new ObjectOutputStream(new FileOutputStream("D:\\dev\\files\\objects.out"));
        ous.writeObject(ob1);
        ous.writeObject(ob2);
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("D:\\dev\\files\\objects.out"));
        Simple o1= (Simple) ois.readObject();
        System.out.println(o1.i);
    }
}