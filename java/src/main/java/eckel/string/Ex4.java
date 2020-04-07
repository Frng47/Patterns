package eckel.string;

import java.util.Formatter;

public class Ex4 {



    public static void main(String[] args) {
        Formatter f=new Formatter();
        String s="Hello";
        System.out.println(f.format("%s",s));
    }

}
class Receipt {
    private double total = 0;
    private int w1=15;
    private int w2=5;
    private int w3=10;
    private  String s1="%-"+w1+ "%"+w2+"s %"+w3+"s\n";
    private Formatter f = new Formatter(System.out);
    public void printTitle() {
        f.format(s1, "Item", "Qty", "Price");
        f.format("%-15s %5s %10s\n", "----", "---", "-----");
    }
    public void print(String name, int qty, double price) {
        f.format("%-15s %5d %10.2f\n", name, qty, price);
        total += price;
    }
    public void printTotal() {
        f.format("%-15s %5s %10.2f\n", "Tax", "", total*0.06);
        f.format("%-15s %5s %10s\n", "", "", "-----");
        f.format("%-15s %5s %10.2f\n", "Total", "",
                total * 1.06);
    }
    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack’s Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
}