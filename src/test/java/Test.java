import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();

        a.add("Hello");
        b.add("Hello");
        a.add("World");
        a.add("!");
        b.add("World");
        b.add("!");

        System.out.println(a.equals(b));
    }
}
