class Solution {
    public boolean validPalindrome(String s) {
        return validPal(s,false);
    }

    public boolean validPal(String s, boolean del) {
        int i =0, j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else if (del == false) {
                return validPal(s.substring(i,j),true) || validPal(s.substring(i+1,j+1),true);
                
            } else {
                return false;
            }
        }
        return true;
    }
}