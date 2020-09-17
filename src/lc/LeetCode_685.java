package lc;

/**
 * 并查集
 *
 * @author Levi
 * @date 2020.9.17
 */
public class LeetCode_685 {
    //并查集
    int[] anc;
    //记录每个点的父亲，为了找到双入度点
    int[] parent;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        anc = new int[edges.length + 1];
        parent = new int[edges.length + 1];
        int[] edge1 = null;
        int[] edge2 = null;
        int[] lastEdgeCauseCircle = null;
        for (int[] pair : edges) {
            int u = pair[0];
            int v = pair[1];

            //初始化并查集
            if (anc[u] == 0) anc[u] = u;
            if (anc[v] == 0) anc[v] = v;

            if (parent[v] != 0) {
                //跳过 edge2,并记下 edge1,edge2
                edge1 = new int[]{parent[v], v};
                edge2 = pair;
            } else {
                parent[v] = u;
                int ancU = find(u);
                int ancV = find(v);
                if (ancU != ancV) {
                    anc[ancV] = ancU;
                } else {
                    //meet a circle , 碰到了环
                    lastEdgeCauseCircle = pair;
                }
            }
        }
        //根据有没有碰到环返回 edge1 或 edge2
        if (edge1 != null && edge2 != null) {
            return lastEdgeCauseCircle == null ? edge2 : edge1;
        }
        //返回那个导致环的最后出现的边。
        return lastEdgeCauseCircle;
    }

    private int find(int node) {
        if (anc[node] == node) {
            return node;
        }
        anc[node] = find(anc[node]);
        return anc[node];
    }
}
