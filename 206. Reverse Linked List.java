class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        List<ListNode> result = new ArrayList<>();
        ListNode end = recursive(head, result);
        end.next = null;
        return result.get(0);
    }
    private static ListNode recursive(ListNode pre, List<ListNode> result){
        if(pre != null && pre.next == null){
            result.add(pre);
            return pre;
        }
        ListNode next = recursive(pre.next, result);
        next.next = pre;
        return pre;
    }
}