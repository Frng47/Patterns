package eckel.lambda;
//Functional interface
public class FunctionalInterfaces {
    interface MyEquation {
        double compute(double val1, double val2);
    }

    public static void main(String[] args) {
        MyEquation area = (height, width) -> height * width;
        MyEquation perimeter = (height, width) -> 2*height + 2*width;
        System.out.println("Area = " + area.compute(3, 4));
        System.out.println("Perimeter = " + perimeter.compute(3, 4));
    }
}
interface FInterface{
    double calculator(double a,double b);
}
class Next{
    public static void main(String[] args) {
        FInterface exmpl=(a,b)->a*b;
        System.out.println(exmpl.calculator(1,1));
    }
}