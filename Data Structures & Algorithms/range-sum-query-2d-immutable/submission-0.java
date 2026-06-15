class NumMatrix {
    int[][] arr;

    public NumMatrix(int[][] matrix) {
        arr = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 1;i<arr.length;i++) {
            int sum = 0;
            for (int j=1;j<arr[0].length;j++) {
                sum += matrix[i-1][j-1];
                arr[i][j] = sum + arr[i-1][j];
            }
        }
        for (int i = 0;i<arr.length;i++) {
            for (int j=0;j<arr[0].length;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1 += 1;
        row2 += 1;
        col1 += 1;
        col2 += 1;
        return arr[row2][col2] - arr[row2][col1-1] - 
        arr[row1-1][col2] + arr[row1-1][col1-1];
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */