package com.xujz.validsudoku;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Solution solution = main.new Solution();
    }

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int size = board[0].length;
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    if(isNumber(board[i][j]) && !checkNumber(board, i, j)) return false;
                }
            }
            return true;
        }

        public boolean isNumber(char c){
            if(c >= '1' && c <= '9'){
                return true;
            } else {
                return false;
            }
        }

        public boolean checkNumber(char[][] board, int x, int y){
            for(int i = 0; i < 9; i++){
                if(i != y){
                    if(board[x][i] == board[x][y]) return false;
                }
                if(i != x){
                    if(board[i][y] == board[x][y]) return false;
                }
            }

            int rowCount = x / 3;
            int colCount = y / 3;
            for(int i = rowCount * 3; i < (rowCount + 1) * 3; i++){
                for(int j = colCount * 3; j < (colCount + 1) * 3; j++){
                    if(i != x && j != y){
                        if(board[i][j] == board[x][y]) return false;
                    }
                }
            }
            return true;
        }
    }
}
