package lc;

/**
 *Distribute candies to people
 *
 * @author Levi
 * @date 2020.3.6
 */
public class LeetCode_1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int x = 0;
        while (!(x * (1 + x) / 2 <= candies && (x + 1) * (2 + x) / 2 > candies)) {
            x++;
        }
        for (int i = 0 ; i < x; i++) {
            res[i % num_people] += (i + 1);
        }
        res[x % num_people] += candies - x * (1 + x) / 2;
        return res;
    }

    public int[] better(int candies, int num_people) {
        int[] res = new int[num_people];
        for (int i = 0; candies > 0;) {
            res[i % num_people] += Math.min(candies, ++i);
            candies -= i;
        }
        return res;
    }

}
