class Solution {
	    public ListNode swapPairs(ListNode head) {
	        ListNode result = new ListNode(0);
	        result.next = head;
	        ListNode temp = result;
	        while(temp.next != null && temp.next.next != null){
	            ListNode pre = temp.next;
	            temp.next = pre.next;
	            pre.next = temp.next.next;
	            temp.next.next = pre;
	            temp = temp.next.next;
	        }
	        return result.next;
	    }
	}