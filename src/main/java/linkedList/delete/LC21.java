package linkedList.delete;

import linkedList.ListNode;

public class LC21 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur = newHead;
        ListNode pre = newHead;

        int length = 0;
        while(cur != null){
            length ++;
            cur = cur.next;
        }

        cur = head;
        int i = 1;
        while(cur != null){
            if(length - i == n){
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;
            i++;
        }
        return newHead.next;


    }
}
