package lc;

import java.math.BigInteger;

/**
 * binary sum
 *
 * @author Levi
 * @date 2020.6.1
 */
public class LeetCode_67 {
    public static String addBinary(int a, int b) {

       int sum = a;
       while (b != 0) {
           sum = a ^ b;
           b = (a & b) << 1;
           a = sum;
       }
       return Integer.toBinaryString(sum);
    }
}
