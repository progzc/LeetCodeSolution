package com.zcprog;

/**
 * 2.两数相加
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next=new ListNode(9);
        l1.next.next=new ListNode(3);

        ListNode l2 = new ListNode(0);
        l2.next=new ListNode(1);
        l2.next.next=new ListNode(2);

        ListNode listNode = addTwoNumbers(l1, l2);

        StringBuilder sb = new StringBuilder();

        if (listNode != null){
            sb.append(listNode.val);
            while (listNode.next != null){
                sb.append(" -> ").append(listNode.next.val);
                listNode = listNode.next;
            }
        }
        System.out.println(sb);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){

        if(l1 == null && l2 == null)
            return null;

        ListNode listNode = new ListNode(0);
        ListNode startNode = listNode;//记录起始节点，用于遍历结果

        int carry = 0;
        while( l1 != null || l2 != null){

            int  x = (l1 != null) ? l1.val : 0;
            int  y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            listNode.val = sum % 10;

            if(l1 != null)  l1 = (l1.next != null) ? l1.next : null;
            if(l2 != null)  l2 = (l2.next != null) ? l2.next : null;

            if(l1 != null || l2 != null || carry >0){
                listNode.next = new ListNode(carry);
                listNode = listNode.next;
            }
        }
        return startNode;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}