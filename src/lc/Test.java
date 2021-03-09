package lc;

import java.util.function.BiPredicate;

public class Test {
    public static void main(String[] args) {

        BiPredicate<String, String> fr = String::equals;
        System.out.println(fr.test("sw", "sw1"));
    }
}
