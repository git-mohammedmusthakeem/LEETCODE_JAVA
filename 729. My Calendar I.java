class MyCalendar {
        private TreeMap<Integer, Integer> map;  //key is the start time and end is the end time
        public MyCalendar() {
            this.map = new TreeMap<>();
        }
        
        public boolean book(int start, int end) {
            // Check the previous one.
            Map.Entry<Integer, Integer> ceiling = this.map.ceilingEntry(start);
            if(ceiling != null){
                if(end > ceiling.getKey()) return false;
            }
            // Check the next one.
            Map.Entry<Integer, Integer> floor = this.map.floorEntry(start);
            if(floor != null){
                if(start < floor.getValue()) return false;
            }
            this.map.put(start, end);
            return true;
        }
    }