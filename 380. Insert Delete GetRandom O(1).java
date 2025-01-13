class RandomizedSet {
      private Map<Integer, Integer> map;
      private List<Integer> nums;
      private Random random;
      /** Initialize your data structure here. */
      public RandomizedSet() {
          this.map = new HashMap<>();
          this.nums = new ArrayList<>();
          this.random = new Random();
      }

      /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
      public boolean insert(int val) {
          if(map.containsKey(val)) return false;
          nums.add(val);
          map.put(val, nums.size() - 1);
          return true;
      }

      /** Removes a value from the set. Returns true if the set contained the specified element. */
      public boolean remove(int val) {
          if(!map.containsKey(val)) return false;
          int index = map.get(val);
          if(index != nums.size() - 1){
              int last = nums.get(nums.size() - 1);
              nums.set(index, last);
              map.put(last, index);
          }
          nums.remove(nums.size() - 1);
          map.remove(val);
          return true;
      }

      /** Get a random element from the set. */
      public int getRandom() {
          return this.nums.get(random.nextInt(nums.size()));
      }
  }