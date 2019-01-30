package code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9x9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */
public class lc36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> row = new HashMap<>();
        HashMap<Integer, HashSet<Character>> column = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cube = new HashMap<>();

        for(int i = 0; i < 9; i++) {
            row.put(i, new HashSet<>());
            column.put(i, new HashSet<>());
            cube.put(i, new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                int cubeNum = (j / 3) * 3 + i / 3;
                if(c == '.') continue;
                if (row.get(i).contains(c) || column.get(j).contains(c) || cube.get(cubeNum).contains(c))
                    return false;
                else {
                    row.get(i).add(c);
                    column.get(j).add(c);
                    cube.get(cubeNum).add(c);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        lc36_ValidSudoku test = new lc36_ValidSudoku();
        boolean result = test.isValidSudoku(board);
        System.out.println(result);
    }
}
