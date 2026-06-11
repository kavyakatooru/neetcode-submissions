class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int sum = 0;
        int count = 0;
        for (char c:s1.toCharArray()) {
            sum += c;
        } 
        System.out.println(sum);
        int i=0, j =0;
        while (j <= s2.length()) {
            while (j-i < s1.length()) {
                count += s2.charAt(j++);
            } 
            if (count == sum && isAnagram(s1, s2.substring(i,j))) return true;
            if (j < s2.length()) {
                count += s2.charAt(j);
                count -= s2.charAt(i);
            }
            i++;
            j++;
        }
        return false;
    }

    public boolean isAnagram(String s1, String s2) {
        int sum = 0;
        for (char c:s1.toCharArray()) {
            if (s2.indexOf(c) == -1) return false;
            sum += (int) c;
        } 
        for (char c:s2.toCharArray()) {
            sum -= (int) c;
        }
        return sum == 0;
    }
}
