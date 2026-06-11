class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        for (int i=1;i<strs.length;i++) {
            int j = compareStrings(ans, strs[i]);
            ans = strs[i].substring(0,j);
        }
        return ans;
        
    }

    public int compareStrings(String str1, String str2) {
        int i =0;
        while (i < str1.length() && i < str2.length()) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return i;
            } else {
                i++;
            }
        }
        return i;
    }
}