class TwoSum {
        private List<Integer> list;
        private Map<Integer, Integer> map;
        /** Initialize your data structure here. */
        public TwoSum() {
            this.list = new ArrayList<>();
            this.map = new HashMap<>();
        }
        
        /** Add the number to an internal data structure.. */
        public void add(int number) {
            this.list.add(number);
            this.map.put(number, map.getOrDefault(number, 0) + 1);
        }
        
        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            for(int i = 0; i < list.size(); i++){
                int num = list.get(i);
                int another = value - num;
                if(num == another && map.get(num) >= 2) return true;
                else if(num != another && map.containsKey(another)) return true;
            }
            return false;
        }
    }