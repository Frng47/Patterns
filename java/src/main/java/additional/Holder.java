package additional;

import java.util.ArrayList;
import java.util.List;

public class Holder {
    Pair<Integer,Integer> pairOne=new Pair<>(1,2);
    Pair<Double,String> pairTwo=new Pair<>(2.55,"OK");
    Pair<String,Pair<Integer,Integer>> pairThree=new Pair<>("OK",new Pair<>(1,2));
}
/*
polymorphism
***universal*** applied to infinite quantities
1. Overriding through inheritance
2. Generics
***ad hoc*** applied to final quantities
3.OverLoading of methods/operators
4.OverLoading of type
 */

//<T> is a type variable
//Type inference
//arrays are covariant(String<:Object then String[]<:Object[] so Object[] obj=new String[]{"Example"};)
//generics are invariant(by default)(ArrayList<Object> list=new ArrayList<String>() - compile error)
class Pair<A,B>{
    private A firstData;
    private B secondData;
    public Pair(A firstData,B secondData){
        this.firstData=firstData;
        this.secondData=secondData;
    }

    public A getFirstData() {
        return firstData;
    }

    public B getSecondData() {
        return secondData;
    }

    public void setFirstData(A firstData) {
        this.firstData = firstData;
    }

    public void setSecondData(B secondData) {
        this.secondData = secondData;
    }
}
class Copier{
    public static void copyObj(Object[] src,Object[] dst){
        int length=Math.min(src.length,dst.length);
        for (int i = 0; i <length ; i++) {
            dst[i]=src[i];
        }
    }
    public static <T> void copyGen(ArrayList<? extends T> src, ArrayList<? super T> dst ){
            int length=Math.min(src.size(), dst.size());
        for (int i = 0; i <length ; i++) {
            dst.set(i,src.get(i));
        }
    }
}

class CopierTest{
    public static void main(String[] args) {
        /*ArrayList<Integer> integers=new ArrayList<Integer>(10);
        integers.add(0,new Integer(1));
        ArrayList<Object> objects=new ArrayList<>(10);
        Copier.copyGen(integers,objects);
        Object noCast=objects.get(0);
        //System.out.println(noCast.toString());*/
        String str="Hello";
        Double d=1.25;
        System.out.println(Mocker.mock(d));
        //Integer extends Number (Integer<:Number)
        //ArrayList<Number> listZero=new ArrayList<Integer>();//don't work because of invariant of generics
        ArrayList<? extends Number> listOne=new ArrayList<Integer>(); // it's works because we transformed invariance to covariance with the help of wildcard
        Number number=null;
        //listOne.add(number);// you can't add number
       //listOne.add(new Integer(5));// you can't add Integer// you can't add anything anymore except null :). You can read  only.
        ArrayList<? super Integer> listTwo=new ArrayList<Number>(); // it's works because we transformed invariance to contravariance with the help of wildcard

        ArrayList<? extends Integer> listYYY=new ArrayList<Integer>();
        ArrayList<? extends Number> listXXX=new ArrayList<Integer>();
        listXXX=listYYY;//correct statement
        //listYYY=listXXX;//incorrect statement
    }
}

class Mocker{
    public static <T> T mock(T arg){
        return arg;
    }
}