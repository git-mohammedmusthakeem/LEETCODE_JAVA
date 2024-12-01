public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur = head;
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode dummyCur = dummy;
        Map<Integer, RandomListNode> m = new HashMap<>();
        while(cur != null){
            dummyCur.next = new RandomListNode(cur.label);
            m.put(cur.label, dummyCur.next);
            dummyCur = dummyCur.next;
            cur = cur.next;
        }
        dummyCur.next = null;
        cur = head;
        dummyCur = dummy.next;
        while(cur != null){
            if(cur.random == null)
                dummyCur.random = null;
            else
                dummyCur.random = m.get(cur.random.label);
            dummyCur = dummyCur.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
