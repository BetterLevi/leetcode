package lc;

/**
 * @author Levi
 * @date 2020.9.17
 */
public class LeetCode_1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0;
        int empty = numBottles;
        while(empty >= numExchange) {
            res += numBottles;
            numBottles = empty / numExchange;
            empty = numBottles + empty % numExchange;
        }
        return res + numBottles;
    }
}
