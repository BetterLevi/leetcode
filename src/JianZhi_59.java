import java.util.Arrays;
import java.util.Deque;

/**
 * @author Levi
 * @date 2020.8.6
 */
public class JianZhi_59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] tmp = new int[k];
        int[] res = new int[nums.length - k + 1];
        int begin = 0;
        while (begin + k < nums.length) {
            System.arraycopy(nums, begin, tmp, 0, k);
            Arrays.sort(tmp);
            res[begin] = tmp[k - 1];
            begin++;
        }
        return res;
    }
}
