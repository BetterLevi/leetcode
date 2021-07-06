package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 点菜展示表
 *
 * @author wei.liang
 * @since 2021/7/6
 */
public class LeetCode_1418 {

    public static List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Map<String, Integer>> tableOrder = new HashMap<>();
        Set<String> tableNumber = new HashSet<>();
        Set<String> foodName = new HashSet<>();
        for (List<String> order : orders) {
            String tableNum = order.get(1);
            tableNumber.add(tableNum);
            String food = order.get(2);
            foodName.add(food);
            Map<String, Integer> foodCount;
            if (tableOrder.containsKey(tableNum)) {
                foodCount = tableOrder.get(tableNum);
                if (foodCount.containsKey(food)) {
                    foodCount.put(food, foodCount.get(food) + 1);
                } else {
                    foodCount.put(food, 1);
                }
            } else {
                foodCount = new HashMap<>();
                foodCount.put(food, 1);
            }
            tableOrder.put(tableNum, foodCount);
        }
        List<List<String>> res = new ArrayList<>();
        List<String> tableHead = new ArrayList<>();
        List<String> tmp = new ArrayList<>(foodName);
        tmp.sort(String::compareTo);
        tableHead.add("Table");
        tableHead.addAll(tmp);
        List<String> tableName = new ArrayList<>(tableNumber);
        tableName.sort(Comparator.comparingInt(Integer::parseInt));
        res.add(tableHead);
        for (String s : tableName) {
            List<String> order = new ArrayList<>();
            order.add(s);
            for (int i = 1; i < tableHead.size(); i++) {
                String food = tableHead.get(i);
                if (tableOrder.get(s) == null || tableOrder.get(s).get(food) == null) {
                    order.add("0");
                } else {
                    order.add(String.valueOf(tableOrder.get(s).get(food)));
                }
            }
            res.add(order);
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "[[\"David\",\"3\",\"Ceviche\"],[\"Corina\",\"10\",\"Beef Burrito\"],[\"David\",\"3\",\"Fried Chicken\"],[\"Carla\",\"5\",\"Water\"],[\"Carla\",\"5\",\"Ceviche\"],[\"Rous\",\"3\",\"Ceviche\"]]";

    }
}
