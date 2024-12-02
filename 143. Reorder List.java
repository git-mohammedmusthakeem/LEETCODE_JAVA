class Solution {
    public void reorderList(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            map.put(count++, cur);
            cur = cur.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        int low = 0, high = count - 1;
        while(low <= high){
            dummy.next = map.get(low++);
            dummy = dummy.next;
            dummy.next = map.get(high--);
            dummy = dummy.next;
        }
        dummy.next = null;
    }
}