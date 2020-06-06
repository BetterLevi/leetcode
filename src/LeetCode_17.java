import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Levi
 * @date 2020.6.6
 */
public class LeetCode_17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        char[] d = digits.toCharArray();
        String[] ds = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < d.length; i++) {
            res = getTwo(res, ds[d[i] - 48]);
        }
        return res;
    }

    public List<String> getTwo(List<String> l1, String s1) {
        List<String> res = new ArrayList<>();
        char[] c1 = s1.toCharArray();
        if (l1.size() == 0) {
            for (char c : c1) {
                res.add(String.valueOf(c));
            }
            return res;
        }
        l1.forEach(l -> {
            for (char c : c1) {
                StringBuilder builder = new StringBuilder(l);
                res.add(builder.append(c).toString());
            }
        });
        return res;
    }


    public List<String> letterCombinations_ans(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while(ans.peek().length()!=digits.length()){
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length())-'0'];
            for(char c: map.toCharArray()){
                ans.addLast(remove+c);
            }
        }
        return ans;
    }
}
