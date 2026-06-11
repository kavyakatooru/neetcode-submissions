class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i =0, max = 0;
        Set<Character> set = new HashSet<>();
        for  (int j =0;j<s.length();j++) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                max = Math.max(set.size(), max);
            } else {
                while (set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.add(s.charAt(j));
            }
        }
        return max;
    }
}
