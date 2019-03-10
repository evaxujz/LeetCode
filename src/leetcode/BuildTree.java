package leetcode;

import leetcode.support.TreeNode;

public class BuildTree {
    public static void main(String[] args) {
        BuildTree b = new BuildTree();
        Solution solution = b.new Solution();
        int[] num1 = new int[]{3,9,20,15,7};
        int[] num2 = new int[]{9,3,15,20,7};
        solution.buildTree(num1, num2);
    }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder == null || preorder.length == 0) return null;
            TreeNode node = new TreeNode(preorder[0]);
            int length = inorder.length;
            int index = 0;
            for(int i = 0; i < length; i++) {
                if(inorder[i] == preorder[0]) {
                    index = i;
                    break;
                }
            }

            if(index > 0) {
                int[] leftPreorder = new int[index];
                System.arraycopy(preorder, 1, leftPreorder, 0, index);
                int[] leftInorder = new int[index];
                System.arraycopy(inorder, 0, leftInorder, 0, index);
                node.left = buildTree(leftPreorder, leftInorder);
            } else {
                node.left = null;
            }

            if(index < length - 1) {
                int[] rightPreorder = new int[length - 1 - index];
                System.arraycopy(preorder, index + 1, rightPreorder, 0, length - 1 - index);

                int[] rightInorder = new int[length - 1- index];
                System.arraycopy(inorder, index + 1, rightInorder, 0, length - 1 - index);
                node.right = buildTree(rightPreorder, rightInorder);
            } else {
                node.right = null;
            }

            return node;
        }
    }
}
