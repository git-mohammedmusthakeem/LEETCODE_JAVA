class MaxStack {
      private PriorityQueue<Integer> pq;
      private LinkedList<Integer> values;
      /** initialize your data structure here. */
      public MaxStack() {
          this.pq = new PriorityQueue<>(new Comparator<Integer>(){
              @Override
              public int compare(Integer a, Integer b){
                  return b - a;
              }
          });
          this.values = new LinkedList<>();
      }

      public void push(int x) {
          this.values.addFirst(x);
          this.pq.offer(x);
      }

      public int pop() {
          Integer first = this.values.pollFirst();
          pq.remove(first);
          return first;
      }

      public int top() {
          return this.values.get(0);
      }

      public int peekMax() {
          return this.pq.peek();
      }

      public int popMax() {
          Integer max = pq.poll();
          this.values.remove(max);
          return max;
      }
  }