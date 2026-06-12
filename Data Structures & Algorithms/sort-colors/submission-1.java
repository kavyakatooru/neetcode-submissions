class Solution {
    public void sortColors(int[] nums) {
        int i=0, k=nums.length-1,l=0;
        while (l <= k) {
            if (nums[l] == 0) {
                swap(nums, i++, l++);
            } else if (nums[l] == 1) {
                l++;
            } else {
                swap(nums, l, k--);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}