package leetcode;

import leetcode.support.ListNode;

/**
 * 相交链表
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class GetIntersectionNode {

    public static void main(String[] args) {
        GetIntersectionNode g = new GetIntersectionNode();
        Solution solution = g.new Solution();
    }

    public static void printNode(ListNode node) {
        ListNode curNode = node;
        while(curNode != null) {
            System.out.print(curNode.val + " ");
            curNode = curNode.next;
        }
        System.out.println();
    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode curA = headA;
            ListNode curB = headB;

            int lenA = 0;
            while(curA != null) {
                lenA++;
                curA = curA.next;
            }

            int lenB = 0;
            while(curB != null) {
                lenB++;
                curB = curB.next;
            }

            curA = headA;
            curB = headB;

            if(lenA > lenB) {
                for(int i = 0; i < lenA - lenB; i++) {
                    curA = curA.next;
                }

                while(curA != null) {
                    if(curA == curB) return curA;
                    curA = curA.next;
                    curB = curB.next;
                }
            } else {
                for(int i = 0; i < lenB - lenA; i++) {
                    curB = curB.next;
                }

                while(curB != null) {
                    if(curA == curB) return curB;
                    curA = curA.next;
                    curB = curB.next;
                }
            }
            return null;
        }
    }
}
