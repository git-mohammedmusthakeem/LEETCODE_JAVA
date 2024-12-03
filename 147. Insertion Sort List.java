class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode ans = dummy;
        while(cur != null){
            ans = dummy;
            while(ans.next != null && ans.next.val < cur.val){
                ans = ans.next;
            }
            ListNode next = cur.next;
            cur.next = ans.next;
            ans.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}