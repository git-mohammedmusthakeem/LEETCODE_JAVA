class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode pre = dummy;
        while(cur != null && cur.next != null){
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            pre.next = cur;
            cur = cur.next;
            pre = pre.next;
        }
        return dummy.next;
    }
}