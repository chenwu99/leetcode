package linkedList;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * 输入：head = [1,4,2,3,2,5,2,1], x = 3
 * 输出：[1,2,2,4,3,5]
 *
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 *
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 */
public class LC86 {

    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur = head;
        ListNode insertPre = newHead;


        while(cur != null){
            if(cur.val >= x){
                break;
            }
            insertPre = cur;
            cur = cur.next;
        }
        ListNode maxCur = cur;
        ListNode next = null;
        ListNode pre = cur;
        int i = 1;
        while(cur != null){//输入：head = [1,4,2,3,2,5,2,1], x = 3*  输出：[1,2,2,4,3,5]
            next = cur.next;
            if(cur.val < x){
                pre.next = next;
                insertPre.next = cur;
                cur.next = maxCur;
                insertPre = cur;
            } else {
                pre = cur;
            }
            cur = next;
        }
        return newHead.next;
    }
}
