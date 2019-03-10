package leetcode;

/**
 * 单词搜索
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用
 */
public class Exist {
    public static void main(String[] args) {
        Exist e = new Exist();
        Solution solution = e.new Solution();
        char[][] board = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution.exist(board, "ABCCED"));
    }

    class Solution {
        public boolean exist(char[][] board, String word) {
            if(board == null) return false;
            int row = board.length;
            int col = board[0].length;
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(exist(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean exist(char[][] board, String word,
                             int curRow, int curCol, int curIndex) {
            int rowSize = board.length;
            int colSize = board[0].length;
            if(curRow < 0 || curRow >= rowSize || curCol < 0 || curCol >= colSize) {
                return false;
            }

            char curChar = word.charAt(curIndex);

            if(curIndex == word.length() - 1) {
                if(board[curRow][curCol] == curChar) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if(board[curRow][curCol] == curChar) {
                    board[curRow][curCol] = '-';
                    if(exist(board, word, curRow - 1, curCol, curIndex + 1) ||
                       exist(board, word, curRow + 1, curCol, curIndex + 1) ||
                       exist(board, word, curRow, curCol - 1, curIndex + 1) ||
                       exist(board, word, curRow, curCol + 1, curIndex + 1)) {
                        board[curRow][curCol] = curChar;
                        return true;
                    } else {
                        board[curRow][curCol] = curChar;
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
    }
}
