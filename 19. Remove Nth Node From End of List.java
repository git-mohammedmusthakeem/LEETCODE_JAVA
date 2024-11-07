## 19. Remove Nth Node From End of List

### Question:
Given a linked list, remove the n-th node from the end of list and return its head.
class Solution {
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        ListNode result = new ListNode(0);
	        result.next = head;
	        int len = 0;
	        ListNode temp = result;
	        while(temp.next != null){
	            temp = temp.next;
	            len ++;
	        }
	        if (len < n) return null;
	        int index = len + 1 - n;
	        len = 0;
	        temp = result;
	        while(temp.next != null){
	            len ++;
	            if(len == index){
	                temp.next = temp.next.next;//Remove
	                return result.next;
	            }
	            temp = temp.next;
	        }
	        return result.next;
	    }
	}