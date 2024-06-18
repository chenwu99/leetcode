package linkedList;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class LC206 {

    public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;
        ListNode next = head.next;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }
}
