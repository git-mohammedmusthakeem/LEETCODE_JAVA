class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode temp = new ListNode(0);
        ListNode cur = head;
        ListNode curTemp = temp;
        ListNode curRes = res;
        int count = 0;
        while(cur != null){
            if((++count) % 2 == 0){
                curTemp.next = cur;
                curTemp = curTemp.next;
            }else{
                curRes.next = cur;
                curRes = curRes.next;
            }
            cur = cur.next;
        }
        curRes.next = temp.next;
        curTemp.next = null;
        return res.next;
    }
}