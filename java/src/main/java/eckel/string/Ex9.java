package eckel.string;

public class Ex9 {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";

    public static void main(String[] args) {
        System.out.println(knights.replaceAll("[aeiouAEIOU]","_"));
        System.out.println(knights.replaceAll("\\W","_"));
        System.out.println(knights.replaceAll("\\w","_"));
    }
}
