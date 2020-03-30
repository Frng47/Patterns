package eckel.innerclass.ex6.pack;

import eckel.innerclass.ex6.pack2.Ex6Interface;
import eckel.innerclass.ex6.pack3.Ex6Base;

public class Ex6 extends Ex6Base {
    Ex6Interface getBaseInner() {
        return this.new Ex6BaseInner();
    }
    public static void main(String[] args) {
    Ex6 ex = new Ex6();
    System.out.println(ex.getBaseInner().say());
}
}