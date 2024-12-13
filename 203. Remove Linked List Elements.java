class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode dummyCur = dummy;
        ListNode cur = head;
        while(cur != null){
            if(cur.val != val){
                dummyCur.next = cur;
                dummyCur = dummyCur.next;
            }
            cur = cur.next;
        }
        dummyCur.next = null;
        return dummy.next;
    }
}