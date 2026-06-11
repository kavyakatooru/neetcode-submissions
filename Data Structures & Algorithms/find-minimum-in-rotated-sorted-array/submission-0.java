class Solution {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length-1;
        int min = nums[0];
        while (i <= j) {
            int mid = i + (j-i)/2;
            if (nums[mid] < nums[0]) min = nums[mid];
            if (nums[mid] > nums[j]) i = mid+1;
            else j = mid-1;
        } 
        return min;
    }
}
