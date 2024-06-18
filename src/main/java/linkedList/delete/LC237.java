package linkedList.delete;

import linkedList.ListNode;

public class LC237 {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }


}
