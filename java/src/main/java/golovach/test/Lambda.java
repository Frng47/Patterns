package golovach.test;

public class Lambda {
    interface fint1{
        void print();
    }
    interface fint2{
        String go(String a, String b);
    }
    public static void main(String[] args) {
        fint1 exp1=()->{
            System.out.println("Lambda");
        };
        exp1.print();
        fint2 exp2=(s1,s2)->{return s1+s2;};
        System.out.println(exp2.go("O","K"));
    }
}
