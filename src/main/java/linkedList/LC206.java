package linkedList;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;
import java.util.concurrent.*;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
public class LC206 {

    public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;
        ListNode next = cur.next;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

    public ListNode k(ListNode head, int k) {

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }


        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
    public Integer caluSum(Integer num1, Integer num2){
        return num1 + num2;
    }



}
