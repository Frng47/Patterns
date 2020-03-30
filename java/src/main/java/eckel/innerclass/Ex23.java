package eckel.innerclass;

public class Ex23 {
    public static void main(String[] args) {
        int count=0;
        B b=new B(5);
        A a=new A();
        for(int k=0;k<5;k++){
            b.add(a.refU());
        }
        b.test();

    }
}
interface U{
    void one();
    void two();
    void three();
}
class A{

    U refU(){
        return new U(){
            public void one() {
                System.out.println("one");
            }
            public void two() {
                System.out.println("two");
            }
            public void three() {
                System.out.println("tree");
            }

        };
    }
}
class B{
    U arrayOfU[];
    int i=0;
    B(int i){
        arrayOfU=new U[i];
    }
    void next(){i++;}
    void add(U item){
        if(i<arrayOfU.length) {arrayOfU[i]=item;next();}
        else System.out.println("out of bound");
    }
    void erase(int i){
        if(i<arrayOfU.length)
        arrayOfU[i]=null;
    }
    void test(){
        for(U u:arrayOfU){
            u.one();
            u.two();
            u.three();
        }
    }
}