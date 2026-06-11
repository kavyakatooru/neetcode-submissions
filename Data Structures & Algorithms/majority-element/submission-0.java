class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, copy = 0;
        for (int num : nums) {
            if (count == 0) {
                copy = num;
            }
            count += (copy == num) ? 1 : -1;
        }
        return copy;
    }
}