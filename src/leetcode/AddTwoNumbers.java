package leetcode;

import leetcode.support.ListNode;

/**
 * 两数相加
 *
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(3);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2_1 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(4);
        l2_1.next = l2_2;
        l2_2.next = l2_3;

        Solution solution = addTwoNumbers.new Solution();
        ListNode sumNode = solution.addTwoNumbers(l1_1, l2_1);

        while(true) {
            System.out.print(sumNode.val + " ");
            sumNode = sumNode.next;
            if(sumNode == null) break;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode headNode = null;
            ListNode preNode = null;
            int carryBit = 0;
            while(true) {
                if(l1 == null && l2 == null && carryBit == 0) return headNode;

                int i1 = l1 == null ? 0 : l1.val;
                int i2 = l2 == null ? 0 : l2.val;

                int sum = i1 + i2 + carryBit;
                carryBit = sum / 10;
                sum %= 10;

                if(preNode == null) {
                    headNode = new ListNode(sum);
                    preNode = headNode;
                } else {
                    preNode.next = new ListNode(sum);
                    preNode = preNode.next;
                }

                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }
        }
    }
}

