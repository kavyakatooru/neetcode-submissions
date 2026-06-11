class Solution {
    public boolean isHappy(int n) {
        int count = 15;
        while (n != 1 && count != 0) {
            int temp = n;
            int sum = 0;
            while (temp != 0) {
                sum += (temp%10)* (temp%10);
                temp = temp/10;
            }
            n = sum;
            count--;
        }
        return n == 1 ? true : false;
    }
}
