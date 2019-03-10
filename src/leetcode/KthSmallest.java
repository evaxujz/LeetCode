package leetcode;

import leetcode.support.TreeNode;

import java.util.LinkedList;

/**
 * 二叉搜索树中第K小的元素
 *
 * 给定一个二叉搜索树, 编写一个函数 kthSmallest 来查找其中第 k 个最小的元素.
 *
 * 中序遍历能够保证元素的顺序, 通过迭代方法,能够在遍历到第k个元素时直接结束迭代.
 */
public class KthSmallest {
    public static void main(String[] args) {
        KthSmallest k = new KthSmallest();

    }

    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            LinkedList<TreeNode> stack = new LinkedList<>();
            TreeNode curNode = root;
            int count = 0;
            while(curNode != null || !stack.isEmpty()) {
                if(curNode != null) {
                    stack.push(curNode);
                    curNode = curNode.left;
                    continue;
                }

                curNode = stack.pop();
                count++;
                if(count == k) return curNode.val;
                curNode = curNode.right;
            }

            return 0;
        }
    }
}
