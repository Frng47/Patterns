package eckel.innerclass;

public class Ex18 {
    static class Nested{
        Nested(String s){
            this.s=s;
        }
        private String s="nested";

        public String getS() {
            return s;
        }
    }
    static Nested getNested(String s){
        return new Nested(s);
    }

    public static void main(String[] args) {
    Nested c=getNested("ssssssssssssss");
        System.out.println(c.getS());
    }
}
