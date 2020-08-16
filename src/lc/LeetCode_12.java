package lc;

/**
 * Integer to Roman
 * @author Levi
 * @date 2020.5.31
 */
public class LeetCode_12 {
    public static String intToRoman(int num) {
        return getRoman(num / 1000, "M") + getHundred(num % 1000 / 100)
                + getTen(num % 1000 % 100 / 10)
                + getSingle(num % 10);

    }

    public static String getHundred(int n) {
        if (n == 9) {
            return "CM";
        }
        if (n >= 5) {
            return getRoman(1, "D") + getRoman(n % 5, "C");
        }
        if (n == 4) {
            return "CD";
        }
        return getRoman(n, "C");
    }

    public static String getTen(int n) {
        if (n == 9) {
            return "XC";
        }
        if (n >= 5) {
            return getRoman(1, "L") + getRoman(n % 5, "X");
        }
        if (n == 4) {
            return "XL";
        }
        return getRoman(n, "X");
    }

    public static String getSingle(int n) {
        if (n == 9) return "IX";
        if (n >= 5) return getRoman(1, "V") + getRoman(n % 5, "I");
        if (n == 4) return "IV";
        return getRoman(n, "I");
    }

    public static String getRoman(int n, String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(s);
        }
        return builder.toString();
    }
}
