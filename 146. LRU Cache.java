class LRUCache {
      private int capacity;
      private Map<Integer, DequeNode> map;
      private DequeNode dummy;
      private DequeNode tail;
      private int size;
      private static class DequeNode{
          public int key;
          public int val;
          public DequeNode pre, next;
          public DequeNode(int key, int val){
              this.key = key;
              this.val = val;
          }
      }
      public LRUCache(int capacity) {
          this.capacity = capacity;
          this.map = new HashMap<>();
          this.size = 0;
          this.dummy = new DequeNode(-1, -1);        
      }

      private void insertHead(DequeNode cur){
          if(cur.pre != null){
              cur.pre.next = cur.next;    //remove current node from the list.
              if(cur.next != null)
                  cur.next.pre = cur.pre;
          }
          DequeNode originalHead = dummy.next;    //insert current node to the head of the list.
          cur.pre = dummy;
          dummy.next = cur;
          cur.next = originalHead;
          if(originalHead != null){
              originalHead.pre = cur;
          }
      }

      public int get(int key) {
          if(!map.containsKey(key)) return -1;
          DequeNode cur = map.get(key);
          if(cur == tail && size != 1){
              this.tail = this.tail.pre;
              this.tail.next = null;
          }
          insertHead(cur);
          return cur.val;
      }

      public void put(int key, int value) {
          if(map.containsKey(key)){
              DequeNode cur = map.get(key);
              if(cur == tail && size != 1){
                  tail = cur.pre;
              }
              cur.val = value;
              insertHead(cur);
          }else{
              DequeNode node = new DequeNode(key, value);
              this.map.put(key, node);
              if(size + 1 <= this.capacity){
                  if(size + 1 == 1){
                      this.tail = node;
                  }
                  insertHead(node);
                  size++;
              }else{
                  // Need to remove the last node and insert current one.
                  insertHead(node);
                  DequeNode originalTail = this.tail;
                  map.remove(originalTail.key);
                  this.tail = this.tail.pre;
                  this.tail.next = null;
              }
          }
      }
  }