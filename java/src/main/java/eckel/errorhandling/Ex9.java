package eckel.errorhandling;

public class Ex9 {
    public static void main(String[] args) throws Exception {
        new Ex9().f();
        System.out.println("END");
    }
        void f() throws Exception {
            System.out.println("<1");
            g();
            System.out.println(">1");

        }
    void g() throws Exception {
        System.out.println("    <1");
        k();

        System.out.println("    >1");

    }
    void k() throws Exception {
        System.out.println("        <1");

        if(true)    throw new Exception();

        System.out.println("        >1");
    }
}

class Rethrowing {
    public static void f() throws Exception {
        System.out.println("originating the exception in f()");
        throw new Exception("thrown from f()");
    }
    public static void g() throws Exception {
        try {
            f();
        } catch(Exception e) {
            System.out.println("Inside g(),e.printStackTrace()");
            e.printStackTrace(System.out);
            throw e;
        }
    }
    public static void h() throws Exception {
        try {
            f();
        } catch(Exception e) {
            System.out.println("Inside h(),e.printStackTrace()");
            e.printStackTrace(System.out);
            throw (Exception)e.fillInStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            g();
        } catch(Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }
        /*try {
            h();
        } catch(Exception e) {
            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }*/
    }
}