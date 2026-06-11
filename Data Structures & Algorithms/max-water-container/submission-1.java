class Solution {
    public int maxArea(int[] heights) {
        int i =0, j = heights.length-1, max = Integer.MIN_VALUE;
        while (i < j) {
            int area = (j-i) * Math.min(heights[i], heights[j]);
            max = Math.max(max, area);
            if (heights[i] > heights[j]) j--;
            else i++;
        }
        return max; 
    }
}
