class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0;i<matrix.length;i++) {
            if (target > matrix[i][matrix[i].length-1]) continue;
            else return binarySearch(matrix[i], target);
        }
        return false;

        
    }

    public boolean binarySearch(int[] arr, int target) {
        int i = 0, j = arr.length-1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (target == arr[mid]) return true;
            else if (target > arr[mid]) i = mid+1;
            else j = mid-1;
        }
        return false;

    }
}
