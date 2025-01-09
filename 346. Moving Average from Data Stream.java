class MovingAverage {
      private Queue<Integer> q;
      private int size;
      private double sum;
      /** Initialize your data structure here. */
      public MovingAverage(int size) {
          this.size = size;
          q = new LinkedList<>();
      }

      public double next(int val) {
          q.offer(val);
          sum += val;
          while(!q.isEmpty() && q.size() > size){
              sum -= q.poll();
          }
          return sum / q.size();
      }
  }