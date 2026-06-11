class Solution {
    public int[] sortArray(int[] nums) {
        qs(nums, 0, nums.length-1);
        return nums;
    }

    public void qs(int[] nums, int i, int j) {
        if (i >=j) return;
        int p = partition(nums, i, j);
        qs(nums, i, p-1);
        qs(nums,p+1,j);

    }

    public int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i =low-1;
        for (int j = low; j<high;j++) {
            if (nums[j] < pivot) {
                swap(nums,++i,j);
            }
        }
        swap(nums,i+1,high);
        return i+1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}