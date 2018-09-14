package leetcode;

/**
 * 链表的中间结点
 *
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {

    public static void main(String[] args) {
        MiddleNode middleNode = new MiddleNode();
    }

    class Solution {
        public ListNode middleNode(ListNode head) {
            if(head.next == null) return head;
            else if(head.next != null && head.next.next == null) return head.next;
            else {
                ListNode preSingle = null;
                ListNode single = head;
                ListNode doubles = head;
                while(true) {
                    preSingle = single;
                    single = single.next;
                    doubles = doubles.next;
                    if(doubles != null) {
                        doubles = doubles.next;
                        if(doubles == null) return single;
                    } else return preSingle;
                }
            }
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

