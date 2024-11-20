class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while(cur.next != null){
            if(cur.next.val != cur.val){
                if(pre.next == cur)
                    pre = pre.next;
                else
                    pre.next = cur.next;
            }
            cur = cur.next;
        }
        if(pre.next != cur)
            pre.next = cur.next;
        return dummy.next;
    }
}