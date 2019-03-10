package leetcode;

import leetcode.support.ListNode;

/**
 * 奇偶链表
 *
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 */
public class OddEvenList {

    public static void main(String[] args) {
        OddEvenList oddEvenList = new OddEvenList();
        Solution solution = oddEvenList.new Solution();
        ListNode headNode = new ListNode(1);
        ListNode curNode = headNode;
        for(int i = 2; i < 10; i++) {
            curNode.next = new ListNode(i);
            curNode = curNode.next;
        }
        ListNode newNode = solution.oddEvenList(headNode);
        curNode = headNode;
        while(curNode != null) {
            System.out.print(curNode.val + " ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    class Solution {
        public ListNode oddEvenList(ListNode head) {
            ListNode curNode = head;
            if(curNode == null) return null;
            ListNode oddHead = curNode;
            ListNode oddTail = curNode;
            curNode = curNode.next;
            if(curNode == null) return oddHead;
            ListNode evenHead = curNode;
            ListNode evenTail = curNode;

            boolean nextOdd = true;
            while(curNode.next != null) {
                curNode = curNode.next;
                if(nextOdd) {
                    oddTail.next = curNode;
                    oddTail = curNode;
                    nextOdd = false;
                } else {
                    evenTail.next = curNode;
                    evenTail = curNode;
                    nextOdd =true;
                }
            }

            oddTail.next = evenHead;
            evenTail.next = null;
            return oddHead;
        }
    }
}
