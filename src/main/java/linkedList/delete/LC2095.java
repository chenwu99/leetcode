package linkedList.delete;

import linkedList.ListNode;

public class LC2095 {

    public ListNode deleteMiddle(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur = newHead;
        ListNode pre = newHead;

        int length = 0;
        while(cur != null){
            length ++;
            cur = cur.next;
        }

        int mid = length / 2 + 1;
        cur = head;
        int i = 1;
        while(cur != null){
            if(i == mid){
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;
            i++;
        }
        return newHead.next;
    }
}
