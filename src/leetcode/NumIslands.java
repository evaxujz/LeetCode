package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *  岛屿的个数
 *
 *  给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 */
public class NumIslands {
    public static void main(String [] args) {
        NumIslands n = new NumIslands();
        Solution solution = n.new Solution();
    }

    class Solution {
        public int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0) return 0;
            int sizeX = grid.length;
            int sizeY = grid[0].length;

            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < sizeX; i++) {
                for(int j = 0; j < sizeY; j++) {
                    if(grid[i][j] == '1')
                        set.add(i * sizeY + j);
                }
            }

            int count = 0;
            if(set.size() == 0) return count;

            while(set.size() != 0) {
                count++;
                List<Integer> curLand = new LinkedList<>();
                int head = set.iterator().next().intValue();
                curLand.add(set.iterator().next().intValue());
                set.remove(head);

                while(curLand.size() != 0) {
                    int cur = curLand.get(0);
                    curLand.remove(0);
                    int[] neighbor = null;
                    /**
                     * 由于将二维数组转换为一维数组, 所以需要考虑左右边界时的邻居选择
                     */
                    if(cur % sizeY == 0) neighbor = new int[] {cur - sizeY, cur + sizeY, cur + 1};
                    else if(cur % sizeY == sizeY - 1) neighbor = new int[] {cur - sizeY, cur + sizeY, cur - 1};
                    else neighbor = new int[] {cur - sizeY, cur + sizeY, cur - 1, cur + 1};
                    for(int pos : neighbor) {
                        if(set.contains(pos)) {
                            curLand.add(pos);
                            set.remove(pos);
                        }
                    }
                }
            }

            return count;
        }
    }
}
