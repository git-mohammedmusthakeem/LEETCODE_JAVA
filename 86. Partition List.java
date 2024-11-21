class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode curDummy = dummy;
        ListNode dummyOther = new ListNode(0);
        ListNode curOther = dummyOther;
        dummy.next = head;
        ListNode cur = dummy.next;
        while(cur != null){
            if(cur.val < x){
                curDummy.next = cur;
                curDummy = curDummy.next;
            }else{
                curOther.next = cur;
                curOther = curOther.next;
            }
            cur = cur.next;
        }
        curOther.next = null;
        curDummy.next = dummyOther.next;
        return dummy.next;
    }
}