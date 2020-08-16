package lc;

public class LeetCode_11 {
    public int maxArea(int[] height) {
        int length = height.length;
        int square = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int width = j - i;
                int high = Math.min(height[i], height[j]);
                square = Math.max(square, width * high);
            }
        }
        return square;
    }
    public int maxAreaOpt(int[] height) {
        int length = height.length;
        int start = 0;
        int end = length - 1;
        int area = 0;
        while (start < end) {
            if (height[start] > height[end]) {
                area = Math.max(area, (end - start) * Math.min(height[start], height[end]));
                end--;
            } else {
                area = Math.max(area, (end - start) * Math.min(height[start], height[end]));
                start++;
            }
        }
        return area;
    }
}
