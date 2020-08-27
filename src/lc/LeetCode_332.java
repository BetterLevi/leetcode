package lc;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Levi
 * @date 2020.8.27
 */
public class LeetCode_332 {
    int edges = 0;
    List<String> res = null;
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> choose = new HashMap<>();
        edges = tickets.size();
        for (List<String> ticket : tickets) {
            if (choose.get(ticket.get(0)) == null) {
                List<String> init = new ArrayList<>();
                init.add(ticket.get(1));
                choose.put(ticket.get(0), init);
            } else {
                List<String> tmp = choose.get(ticket.get(0));
                tmp.add(ticket.get(1));
                choose.put(ticket.get(0), tmp);
            }
        }
        for (Map.Entry<String, List<String>> entry : choose.entrySet()) {
            Collections.sort(entry.getValue());
        }
        backTracking("JFK", choose, new ArrayList<>());
        return res;

    }

    public void backTracking(String next, Map<String, List<String>> choose, List<String> tmp) {
        if (res != null) {
            return;
        }
        tmp.add(next);
        if (tmp.size() == edges + 1) {
            res = new ArrayList<>(tmp);
            return;
        }
        List<String> nextChoose = choose.get(next);
        for (int i = 0; res == null &&  nextChoose != null && i < nextChoose.size(); i++) {
            String nextPlace = nextChoose.remove(i);
            backTracking(nextPlace, choose, tmp);
            nextChoose.add(i, nextPlace);
        }
        tmp.remove(tmp.size() - 1);
    }



    /**
     * WRONG：这种做法会出现断路现象
     */
    public void helper(String begin, List<String> res, ArrayList<List<String>> tickets) {
        res.add(begin);
        if (tickets.size() == 1) {
            res.add(tickets.get(0).get(1));
            return;
        }
        List<List<String>> tmp = new ArrayList<>();
        for (List<String> ticket : tickets) {
            if (begin.equals(ticket.get(0))) {
                tmp.add(Arrays.asList(ticket.get(0), ticket.get(1)));
            }
        }
        String next = tmp.get(0).get(1);
        for (int i = 1; i < tmp.size(); i++) {
            next = next.compareTo(tmp.get(i).get(1)) > 0 ? tmp.get(i).get(1) : next;
        }
        tickets.remove(Arrays.asList(begin, next));
        helper(next, res, tickets);
    }

    public static void main(String[] args) {
        LeetCode_332 l = new LeetCode_332();
        List<List<String>> t = Arrays.asList(Arrays.asList("MUC","LHR"),
                Arrays.asList("JFK","MUC"), Arrays.asList("SFO","SJC"), Arrays.asList("LHR","SFO"));
        l.findItinerary(t);
    }
}
