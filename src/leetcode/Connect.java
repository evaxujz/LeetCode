package leetcode;

import leetcode.support.TreeLinkNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 每个节点的右向指针
 *
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL.
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 说明:
 *
 * 你只能使用额外常数空间.
 * 使用递归解题也符合要求,本题中递归程序占用的栈空间不算做额外的空间复杂度.
 * 你可以假设它是一个完美二叉树(即所有叶子节点都在同一层，每个父节点都有两个子节点).
 */
public class Connect {
    public static void main(String[] args) {
        Connect c = new Connect();
        Solution solution = c.new Solution();
    }

    public class Solution {
        public void connect(TreeLinkNode root) {
            if(root == null) return;
            List<TreeLinkNode> curLevel = new ArrayList<>();
            List<TreeLinkNode> nextLevel = new ArrayList<>();

            curLevel.add(root);
            while(!curLevel.isEmpty()) {
                for(int i = 0, len = curLevel.size(); i < len; i++) {
                    TreeLinkNode node = curLevel.get(i);
                    if(node == null) continue;
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                    if(i != curLevel.size() - 1)
                        node.next = curLevel.get(i + 1);
                }
                curLevel.clear();
                curLevel.addAll(nextLevel);
                nextLevel.clear();
            }
        }
    }
}
