package linkedList;

/**
 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 示例 1:
 输入：head = [1,2,3,4,5], left = 2, right = 4
 输出：[1,4,3,2,5]

 示例 2:
 输入：head = [5], left = 1, right = 1
 输出：[5]
 */
public class LC92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(left == right){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        int i = 1;
        ListNode revHead = dummyHead;
        ListNode result = revHead;
        ListNode cur = head;
        ListNode next = null;
        ListNode leftStart = null;


        while (cur != null) {
            next = cur.next;
            if (i >= left && i <= right) {
                System.out.println("revHead = " + revHead.val);
                if(left == 1 && left == i){
                    revHead.next = null;
                }
                ListNode revHeadNext = revHead.next;
                cur.next = revHeadNext;
                if(i == left){
                    leftStart = cur;
                }
                revHead.next = cur;
            } else if(i > right){
                leftStart.next = cur;
                break;
            } else if(i < left){
                revHead.next = cur;
                revHead = revHead.next;
            }
            cur = next;
            i++;
        }
        return result.next;

    }
}
