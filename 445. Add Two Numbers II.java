class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // Reverse both list;
            ListNode pre = null, next = l1.next, cur = l1;
            while(cur != null){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            l1 = pre;
            pre = null;
            next = l2.next;
            cur = l2;
            while(cur != null){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            l2 = pre;
            ListNode dummy = new ListNode(0);
            cur = dummy;
            int carry = 0;
            while(l1 != null || l2 != null){
                int sum = 0;
                if(l1 != null && l2 != null){
                    sum = l1.val + l2.val + carry;
                    l1 = l1.next;
                    l2 = l2.next;
                }else if(l1 != null){
                    sum = l1.val + carry;
                    l1 = l1.next;
                }else{
                    sum = l2.val + carry;
                    l2 = l2.next;
                }
                cur.next = new ListNode(sum % 10); 
                carry = sum / 10;
                cur = cur.next;
            }
            if(carry == 1) cur.next = new ListNode(1);
            pre = null; cur = dummy.next; next = cur.next;
            while(cur != null){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }