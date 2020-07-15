import java.util.*;

/**
 * @author Levi
 * @date 2020.7.9
 */
public class LeetCode_17_13 {
    public static int respace(String[] dictionary, String sentence) {
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < dictionary.length; i++) {
            int index = sentence.indexOf(dictionary[i]);
            if (index == -1) {
                continue;
            }
            indexs.add(index);
        }
        indexs.sort(Comparator.comparing(Integer::intValue));
        List<String> words = new ArrayList<>();
        for (int i = 0; i < indexs.size(); i++) {
            if (i == 0) {
                words.add(sentence.substring(0, indexs.get(i)));
            } else if (i == indexs.size() - 1) {
                words.add(sentence.substring(indexs.get(i)));
            } else {
                words.add(sentence.substring(indexs.get(i), indexs.get(i + 1)));
            }
        }
        int res = 0;
        List<String> ds = Arrays.asList(dictionary);
        for (int i = 0; i < words.size(); i++) {
            if (!ds.contains(words.get(i))) {
                res += words.get(i).length();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] d = new String[]{"looked","just","like","her","brother"};
        String s = "jesslookedjustliketimherbrother";
        respace(d, s);
    }
}
