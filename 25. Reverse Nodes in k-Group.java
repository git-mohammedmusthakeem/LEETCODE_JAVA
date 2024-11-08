public class Node {
	public static void main(String[] args) {
		ListNode<Integer> dummy = new ListNode<Integer>(0);
		ListNode<Integer> temp = dummy;
		for(int i = 1; i < 10; i++){
			temp.next = new ListNode<Integer>(i);
			temp = temp.next;
		}
		//Try to inverse the list.
		ListNode<Integer> pre = null;
		ListNode<Integer> node = dummy.next;
		while(node != null){
			ListNode<Integer> next = node.next;
			node.next = pre;
			pre = node;
			node = next;
		}
		int count = 0;
		while(pre != null && count < 20){
			System.out.print(pre.val + "	");
			pre = pre.next;
			count++;
		}
	}
	private static class ListNode<T>{
		ListNode<T> next;
		T val;
		public ListNode(T val) {this.val = val;}
	}
}