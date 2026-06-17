class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, leftSum = 0;
        int i =0, j = 0;
        while (i < nums.length) {
            if (j == nums.length) {
                i++;
                j = i;
                leftSum = 0;
                continue;
            }
            if (nums[j] + leftSum == k) {
                count++;
            }
            leftSum += nums[j++];
        }
        return count;
    }
}