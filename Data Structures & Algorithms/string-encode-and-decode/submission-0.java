class Solution {

    public String encode(List<String> strs) {
        String ans = "";
        for (String str: strs) {
            ans += str.length() + "#" + str;
        }
        System.out.println(ans);
        return ans;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        int i =0;
        while (i < s.length()) {
            int idx = i;
            while (s.charAt(idx) != '#') idx++;
            int len = Integer.valueOf(s.substring(i,idx));
            i = idx + 1 + len;
            ans.add(s.substring(idx+1, i));
        }
        return ans;

    }
}
