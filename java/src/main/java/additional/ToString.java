package additional;

public class ToString {
    //String [] string=new String[5];
    String [] string={"a","b","c"};

    String toStringUpd(){
StringBuilder builder=new StringBuilder();
    for (int i = 0; i < string.length; i++) {
        builder.append(" ").append(string[i]);
    }
        return builder.toString();
    }

    public static void main(String[] args) {

           System.out.println("Hello"+args[1]);


    }
}
