package lc;

/**
 * @author wei.liang
 * @since 2021/2/8
 */
public class SimpleCollection {
    /**
     * JianZhi-58 翻转单词顺序
     * @param s String
     * @return s after reverse
     */
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            res.append(words[i]).append(" ");
        }
        return res.toString().trim();
    }





    public static void main(String[] args) {
        SimpleCollection sc = new SimpleCollection();
        sc.reverseWords("a good   example");
    }
}
