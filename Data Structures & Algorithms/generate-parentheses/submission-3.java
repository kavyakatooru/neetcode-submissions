class Solution {
    List<String> list;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        generate(n, n, "");
        return list;
    }

    public void generate(int open, int close, String ans) {
        if (open == 0 && close == 0) {
            list.add(ans);
            return;
        }
        if (open > close || open < 0 || close < 0) return;
        
        if (open > 0) generate(open-1,close,ans+"(");
        if (close > 0) generate(open, close-1,ans+")"); 
    }
    
}
