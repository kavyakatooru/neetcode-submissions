class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    public int[] mergeSort(int[] nums, int i, int j) {
        if (i >= j) return new int[]{nums[i]};
        int mid = i + (j - i) / 2;
        int[] arr1 = mergeSort(nums, i, mid);
        int[] arr2 = mergeSort(nums, mid+1, j);
        return merge(arr1, arr2);

    }

    public int[] merge(int[] arr1, int[] arr2) {
        int i=0, j = 0, k = 0;
        int[] arr = new int[arr1.length + arr2.length];
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[k++] = arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                arr[k++] = arr2[j++];
            } else {
                arr[k++] = arr1[i++];
                arr[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            arr[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            arr[k++] = arr2[j++];
        }
        return arr;
    }
}