package jianzhi;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 字符串的排列
 *
 * @author wei.liang
 * @since 2021/6/22
 */
public class JianZhi_38 {
    public String[] permutation(String s) {
        LinkedList<String> str = new LinkedList<>();
        Set<String> res = new HashSet<>();
        Set<Integer> index = new HashSet<>();
        backTracking(res, s.toCharArray(), str, index);
        return res.toArray(new String[0]);
    }

    public void backTracking(Set<String> res, char[] cs, LinkedList<String> str, Set<Integer> index) {
        if (str.size() == cs.length) {
            res.add(String.join("", str.toArray(new String[0])));
            return;
        }
        for (int i = 0; i < cs.length; i++) {
            if (index.contains(i)) {
                continue;
            }
            str.addLast(String.valueOf(cs[i]));
            index.add(i);
            backTracking(res, cs, str, index);
            str.removeLast();
            index.remove(i);
        }
    }

    public static void main(String[] args) {
        JianZhi_38 lc = new JianZhi_38();
        System.out.println(String.join(",", lc.permutation("abc")));
    }
}
