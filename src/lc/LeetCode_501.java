package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Levi
 * @date 2020.9.24
 */
public class LeetCode_501 {
    public int[] findMode(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        if(res.size() == 1) {
            return new int[]{res.get(0)};
        }
        List<Integer> many = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < res.size() - 1; i++) {
            int j = i + 1;
            while(j < res.size() && res.get(j) == res.get(i)) {
                j++;
            }
            int tmp = j - i;
            if(tmp > count) {
                many.clear();
                many.add(res.get(i));
                count = tmp;
            } else if(tmp == count) {
                many.add(res.get(i));
            }
            i = j;
        }
        int[] r = new int[many.size()];
        for(int i = 0; i < many.size(); i++) {
            r[i] = many.get(i);
        }
        return r;
    }

    public int[] test(List<Integer> res) {
        if(res.size() == 1) {
            return new int[]{res.get(0)};
        }
        List<Integer> many = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < res.size() - 1; i++) {
            int j = i + 1;
            while(j < res.size() && res.get(j) == res.get(i)) {
                j++;
            }
            int tmp = j - i;
            if(tmp > count) {
                many.clear();
                many.add(res.get(i));
                count = tmp;
            } else if(tmp == count) {
                many.add(res.get(i));
            }
            i = j - 1;
        }
        int[] r = new int[many.size()];
        for(int i = 0; i < many.size(); i++) {
            r[i] = many.get(i);
        }
        return r;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    public static void main(String[] args) {
        LeetCode_501 lc = new LeetCode_501();
        List<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(1);
        res.add(1);
        res.add(2);
        res.add(2);
        res.add(2);
        lc.test(res);
    }
}
