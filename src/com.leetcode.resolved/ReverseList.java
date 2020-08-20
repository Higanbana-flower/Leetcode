package com.leetcode.resolved;

public class ReverseList {
    // 1.反转一个单链表 普通
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    // 2.反转一个单链表 递归
    public ListNode reverseList1(ListNode head) {
        return reverseList2(head, null);
    }

    private ListNode reverseList2(ListNode head, ListNode next) {
        if (head == null) {
            return next;
        }
        ListNode temp = head.next;
        head.next = next;
        return reverseList2(temp, head);
    }

    // 3.反转链表 递归 不适用新方法
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 递归得出最后最后子链元素 此时 newHead 为链表尾部元素， head为倒数第二元素依次递归。
        ListNode newHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
