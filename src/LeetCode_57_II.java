import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * e.g
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * @author Levi
 * @date 2020.3.6
 */
public class LeetCode_57_II {
    //滑动窗口
    public int[][] findContinuousSequence(int target) {
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        int i = 1, j = 1;
        while (i <= target / 2) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++){
                    arr[k - i] = k;
                }
                res.add(arr);
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public int[][] another(int target) {
        List<int[]> result = new ArrayList<>();
        int i = 1;
        while(target > 0)
        {
            target -= i++;
            if(target > 0 && target % i == 0)
            {
                int[] array = new int[i];
                for(int k = target / i, j = 0; k < target / i + i; k++, j++)
                {
                    array[j] = k;
                }
                result.add(array);
            }
        }
        Collections.reverse(result);
        return result.toArray(new int[0][]);
    }

}
