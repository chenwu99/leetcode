package linkedList.delete;

import linkedList.ListNode;

public class LC136 {

    public ListNode deleteNode(ListNode head, int val) {

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur = newHead;
        ListNode pre = newHead;

        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }
            pre = cur;
            cur = cur.next;
        }
        return newHead.next;
    }
}
