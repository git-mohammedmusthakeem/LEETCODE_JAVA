class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head, temp = null;
        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }
    private static ListNode merge(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while(node1 != null || node2 != null){
            if(node1 == null){
                dummy.next = node2;
                node2 = node2.next;
            }else if(node2 == null){
                dummy.next = node1;
                node1 = node1.next;
            }else if(node1.val <= node2.val){
                dummy.next = node1;
                node1 = node1.next;
            }else{
                dummy.next = node2;
                node2 = node2.next;
            }
            dummy = dummy.next;
        }
        return result.next;
    }
}