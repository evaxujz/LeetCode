package leetcode;

/**
 * 矩阵置零
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗? 将O(m + n)方案中的额外空间用matrix矩阵的第一行与第一列来代替
 */
public class SetZeroes {

    public static void main(String[] args) {
        SetZeroes setZereos = new SetZeroes();
        Solution solution = setZereos.new Solution();
    }

    class Solution {
        public void setZeroes(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;

            boolean firstRow = false;
            boolean firstCol = false;

            for(int i : matrix[0]) {
                if(i == 0) {
                    firstRow = true;
                    break;
                }
            }

            for(int i = 0; i < row; i++) {
                if(matrix[i][0] == 0) {
                    firstCol = true;
                    break;
                }
            }

            for(int i = 1; i < row; i++) {
                for(int j = 1; j < col; j++) {
                    if(matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }

            for(int i = 1; i < row; i++) {
                if(matrix[i][0] == 0) {
                    for(int j = 1; j < col; j++) matrix[i][j] = 0;
                }
            }
            for(int i = 1; i < col; i++) {
                if(matrix[0][i] == 0) {
                    for(int j = 1; j < row; j++) matrix[j][i] = 0;
                }
            }

            if(firstRow) {
                for(int i = 0; i < col; i++) matrix[0][i] = 0;
            }
            if(firstCol) {
                for(int i = 1; i < row; i++) matrix[i][0] = 0;
            }
        }
    }
}
