class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 1) return;
        k = (k >= nums.length) ? (k%nums.length) : k;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums, int i, int j) {
        while (i<j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}