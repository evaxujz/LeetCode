package leetcode;

import leetcode.support.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 中序遍历二叉树(迭代)
 */
public class InorderTraversal {

    public static void main(String[] args) {
        InorderTraversal i = new InorderTraversal();
        Solution solution = i.new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        TreeNode rightLeft = new TreeNode(3);
        right.left = rightLeft;
        solution.inorderTraversal(root);
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            ArrayList<Integer> array = new ArrayList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode curNode = root;
            while(curNode != null || !stack.isEmpty()) {
                if(curNode != null) {
                    stack.push(curNode);
                    curNode = curNode.left;
                    continue;
                }
                if(!stack.isEmpty()) {
                    curNode = stack.pop();
                    array.add(curNode.val);
                    curNode = curNode.right;
                }
            }
            return array;
        }
    }
}
