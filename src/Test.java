public class Test {
    public static void main(String[] args) {
        int[] data = new int[]{-1, 2, 1, -4};
        int[] dataA = new int[] {2,7,9,3,1};
        int[][] dataB = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        LeetCode_88 leetCode_88 = new LeetCode_88();
        leetCode_88.sort(dataA, 0, 4);
    }
}
