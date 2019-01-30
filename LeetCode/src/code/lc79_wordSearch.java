package code;

public class lc79_wordSearch {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0)
            return true;
        int[][] flags = new int[board.length][board[0].length];
        return isRight(board, flags, 0, 0, word, 0);
    }

    private boolean isRight(char[][] board, int[][] flags, int x, int y, String word, int i) {
        if (i == word.length() || x < 0 || x >= board.length || y < 0 || y >= board[0].length || flags[x][y] == 1)
            return false;
        if (board[x][y] == word.charAt(i)) {
            if (i == word.length() - 1)
                return true;
            else {
                flags[x][y] = 1;
                boolean child = isRight(board, flags, x - 1, y, word, i + 1)
                        || isRight(board, flags, x + 1, y, word, i + 1)
                        || isRight(board, flags, x, y - 1, word, i + 1)
                        || isRight(board, flags, x, y + 1, word, i + 1);
                if (child)
                    return true;
                else {
                    flags[x][y] = 0;
                    return false;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        lc79_wordSearch test = new lc79_wordSearch();
        char[][] a = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(test.exist(a, "ESCC"));
    }
}
