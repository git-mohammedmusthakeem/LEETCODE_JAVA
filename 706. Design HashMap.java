class MyHashMap {
        private static class Node{
            int key;
            int val;
            Node next;
            public Node(int key, int val){
                this.key = key;
                this.val = val;
            }
        }
        private Node[] bucket;
        private static final int size = 10000;
        /** Initialize your data structure here. */
        public MyHashMap() {
            this.bucket = new Node[size];
        }
        
        /** value will always be non-negative. */
        public void put(int key, int value) {
            int index = hash(key);
            if(bucket[index] == null) bucket[index] = new Node(-1, 0);
            Node pre = find(bucket[index], key);
            if(pre.next == null) pre.next = new Node(key, value);
            else pre.next.val = value;
        }
        
        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int index = hash(key);
            Node pre = find(bucket[index], key);
            if(pre == null || pre.next == null) return -1;
            return pre.next.val;
        }
        
        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int index = hash(key);
            Node pre = find(bucket[index], key);
            if(pre == null || pre.next == null) return;
            pre.next = pre.next.next;
        }
        private Node find(Node head, int key){
            if(head == null) return head;
            Node pre = head, temp = head.next;
            while(temp != null && temp.key != key){
                pre = temp;
                temp = temp.next;
            }
            return pre;
        }
        private int hash(int key){
            return Integer.hashCode(key) % size;
        }
    }