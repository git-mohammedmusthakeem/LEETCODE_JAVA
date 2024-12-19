class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        List<Integer> temp = new LinkedList<>();
        while(cur != null){
            temp.add(cur.val);
            cur = cur.next;
        }
        Integer[] arr = new Integer[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            arr[i] = (Integer)temp.get(i);
        }
        int start = 0, end = arr.length - 1;
        while(start < end){
            if(!arr[start++].equals(arr[end--])){
                return false;
            }
        }
        return true;
    }
}