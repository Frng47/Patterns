package patterns.structural.decorator;

public class DecoratorApp {
    public static void main(String[] args) {
        PrinterInt printer=new LeftBracketDecorator(new RightBracketDecorator(new Printer("Hello!")));
       printer.print();
    }
}
interface PrinterInt{
    void print();
}
abstract class Decorator implements PrinterInt{
    PrinterInt component;
    public Decorator(PrinterInt component){
        this.component=component;
    }
}
class Printer implements PrinterInt{
    String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}
class QuotesDecorator extends Decorator{

    public QuotesDecorator(PrinterInt component) {
        super(component);
    }

    public void print() {
        System.out.print("\"");
    component.print();
        System.out.println(" \"");
    }
}
class LeftBracketDecorator extends Decorator{


    public LeftBracketDecorator(PrinterInt component) {
        super(component);
    }

    public void print() {
        System.out.print("[");
        component.print();
    }
}
class RightBracketDecorator extends Decorator{

    public RightBracketDecorator(PrinterInt component) {
        super(component);
    }

    public void print() {

        component.print();
        System.out.print("]");
    }
}