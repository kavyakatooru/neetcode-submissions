class Solution {
    public int[] productExceptSelf(int[] nums) {
        int j = nums.length;
        int[] left = new int[j];
        int[] right = new int[j];
        left[0] = 1;
        right[j-1] = 1;
        for (int i=1;i<j;i++) {
            left[i] = left[i-1] * nums[i-1];
            right[j-1-i] = right[j-i] * nums[j-i];
        }

        for (int i=0;i<j;i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
}  
