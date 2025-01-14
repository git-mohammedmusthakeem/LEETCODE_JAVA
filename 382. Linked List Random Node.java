class Solution {
        private ListNode head;
        private Random random;
        /** @param head The linked list's head.
            Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
            this.random = new Random();
        }
        
        /** Returns a random node's value. */
        public int getRandom() {
            ListNode cur = head.next;
            int count = 1;
            ListNode hold = head;
            while(cur != null){
                count++;
                int rand = random.nextInt(count) + 1;
                if(rand == count) hold = cur;
                cur = cur.next;
            }
            return hold.val;
        }
    }