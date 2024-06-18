package linkedList.delete;

import linkedList.ListNode;

public class LC83 {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode cur = head;
        ListNode pre = newHead;

        while(cur != null){
            if(cur.val == pre.val){
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return newHead.next;
    }
}
