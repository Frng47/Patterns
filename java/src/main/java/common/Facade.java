
/*public class Facade {
    public static void main(String[] args){
    OneTwo a=new OneTwo();
    a.zero();
    }
}*/


class One {
    public void oner() {
        System.out.println("One");
    }
}

class Two{
    public void twoer(){
        System.out.println("Two");
    }
}

class OneTwo{
    One one=new One();
    Two two=new Two();
    public void zero(){
        System.out.println("Zero");
        one.oner();
        two.twoer();
    }
    public void onetwo(){
         this.zero();

        System.out.println("OneTwo");
    }
}