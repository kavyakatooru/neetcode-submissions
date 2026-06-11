class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len-1] != 9) {
            digits[len-1] = digits[len-1]+1;
            return digits;
        } 
        int i =len-1;
        while (i >= 0 && digits[i] == 9) {
            if (i == 0) {
                int[] arr = new int[len+1];
                arr[0] = 1;
                return arr;
            }
            digits[i--] = 0;
            
        }
        digits[i] = digits[i]+1;
        return digits;
    }
}
