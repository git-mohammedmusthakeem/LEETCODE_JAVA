class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while(l1 != null || l2 != null){
            int val = 0;
            if(l1 != null && l2 != null){
                val = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1 != null){
                val = l1.val + carry;
                l1 = l1.next;
            }else{
                val = l2.val + carry;
                l2 = l2.next;
            }
            cur.next = new ListNode(val % 10);
            carry = val / 10;
            cur = cur.next;
        }
        if(carry == 1)
            cur.next = new ListNode(1);
        return res.next;
    }
}
