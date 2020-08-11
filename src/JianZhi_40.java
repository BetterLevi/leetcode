import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的k个数
 * @author Levi
 * @date 2020.8.7
 */
public class JianZhi_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    public static int[] getLeastNumber_bet(int[] arr, int k) {
        Queue<Integer> bigQue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                bigQue.offer(arr[i]);
            } else {
                if (bigQue.peek() > arr[i]) {
                    bigQue.poll();
                    bigQue.offer(arr[i]);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = bigQue.poll();
        }
        return res;
    }
}
