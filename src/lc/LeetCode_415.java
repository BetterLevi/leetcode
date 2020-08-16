package lc;

/**
 * 字符串相加
 *
 * @author Levi
 * @date 2020.8.3
 */
public class LeetCode_415 {
    public static String addStrings(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder builder = new StringBuilder();
        int add = 0;
        while (len1 > 0 && len2 > 0) {
            int tmp = (n1[len1 - 1] - 48) + (n2[len2 - 1] - 48) + add;
            add = tmp / 10;
            builder.append(tmp % 10);
            len1--;
            len2--;
        }
        while (len1 > 0) {
            int tmp = (n1[len1 - 1] - 48) + add;
            add = tmp / 10;
            builder.append(tmp % 10);
            len1--;
        }
        while (len2 > 0) {
            int tmp = (n2[len2 - 1] - 48) + add;
            add = tmp / 10;
            builder.append(tmp % 10);
            len2--;
        }
        if (add == 1) {
            builder.append(add);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("6", "501"));
    }
}
