package leetcode;

import leetcode.support.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的锯齿形层次遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历.(即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行)
 */
public class ZigzagLevelOrder {

    public void main(String[] args) {
        ZigzagLevelOrder z = new ZigzagLevelOrder();
        Solution solution = z.new Solution();

    }

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root == null) return result;
            List<TreeNode> curLevel = new ArrayList<>();
            List<TreeNode> nextLevel = new ArrayList<>();

            int left2Right = 1;
            curLevel.add(root);

            while(!curLevel.isEmpty()) {
                List<Integer> valList = new ArrayList<>();
                for(TreeNode node : curLevel) {
                    valList.add(node.val);
                    if(node.left != null) nextLevel.add(node.left);
                    if(node.right != null) nextLevel.add(node.right);
                }

                if(left2Right != 1) {
                    List<Integer> list = new ArrayList<>();
                    for(int i = valList.size() - 1; i >= 0; i--)
                        list.add(valList.get(i));
                    result.add(list);
                } else {
                    result.add(valList);
                }

                left2Right = ~left2Right;
                curLevel.clear();
                curLevel.addAll(nextLevel);
                nextLevel.clear();
            }

            return result;
        }
    }
}
