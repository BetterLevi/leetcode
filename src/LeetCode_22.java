import java.util.ArrayList;
import java.util.List;

/**
 * @author Levi
 * @date 2020.6.9
 */
public class LeetCode_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res, "", 0, 0, n);
        return res;

    }
    public void backTrack(List<String> res, String cur,
                          int left, int right, int max) {
        if(right == max) {
            res.add(cur);
            return;
        }
        if(left < max) {
            backTrack(res, cur + "(", left + 1, right, max);
        }
        if(right < left) {
            backTrack(res, cur + ")", left, right + 1, max);
        }
    }

    public static void main(String[] args) {
        LeetCode_22 leetCode_22 = new LeetCode_22();
        leetCode_22.generateParenthesis(3);
    }
}
