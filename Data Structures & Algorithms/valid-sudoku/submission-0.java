class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> grid1 = new HashSet<>();
        Set<Character> grid2 = new HashSet<>();
        Set<Character> grid3 = new HashSet<>();
        for (int i=0;i<board.length;i++) {
            Set<Character> hor = new HashSet<>();
            Set<Character> ver = new HashSet<>();
            for (int j=0;j<board.length;j++) {            
                if (hor.contains(board[i][j]) || ver.contains(board[j][i])) return false;
                if (board[i][j] != '.') hor.add(board[i][j]);
                if (board[j][i] != '.') ver.add(board[j][i]);

                if (j/3 == 0 ) {
                    if (grid1.contains(board[i][j])) return false;
                    if (board[i][j] != '.') grid1.add(board[i][j]);
                }
                else if (j/3 == 1) {
                    if (grid2.contains(board[i][j])) return false;
                    if (board[i][j] != '.') grid2.add(board[i][j]);
                }
                else if (j/3 == 2) {
                    if (grid3.contains(board[i][j])) return false;
                    if (board[i][j] != '.') grid3.add(board[i][j]);
                }
            }
            if (i == 2 || i == 5) {
                grid1.clear();
                grid2.clear();
                grid3.clear();

            }
            hor.clear();
            ver.clear();
        }
        return true;
    }
}
