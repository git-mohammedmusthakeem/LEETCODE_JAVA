class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode mNode = null;
        while(cur.next != null && count < m - 1){
            count++;
            cur = cur.next;
        }
        mNode = cur;
        List<ListNode> result = new ArrayList<>();
        ListNode end = recursive(mNode.next, m, n, result);
        mNode.next = result.get(0);
        end.next = result.get(1);
        return dummy.next;
    }
    private static ListNode recursive(ListNode head, int count, int n, List<ListNode> result){
        if(count == n){
            result.add(head);
            result.add(head.next);
            return head;
        }else{
            count++;
            ListNode next = recursive(head.next, count, n, result);
            next.next = head;
            return head;
        }
    }
}