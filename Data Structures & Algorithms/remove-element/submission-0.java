class Solution {
    public int removeElement(int[] nums, int val) {
        int i =0, j = nums.length-1;
        int ans = 0;
        while (i <= j) {
            if (nums[i] == val) {
                while(nums[j] == val && j > i) {
                    j--;
                }

                nums[i] = nums[j];
                nums[j] = val;
                j--;
            } else {
                ans++;
                i++;
            }
        }
        return ans;
    }
}