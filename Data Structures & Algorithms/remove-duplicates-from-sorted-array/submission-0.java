class Solution {
    public int removeDuplicates(int[] nums) {
        int i =0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                swap(nums, i+1,j);
                j++;
                i++;
            }
        }
        return i+1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}