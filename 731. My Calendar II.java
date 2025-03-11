class MyCalendarTwo {
        private List<int[]> calendar;
        private List<int[]> overlap;
        public MyCalendarTwo() {
            this.calendar = new ArrayList<>();
            this.overlap = new ArrayList<>();
        }
        
        public boolean book(int start, int end) {
            for(int[] o : overlap){
                if(Math.max(o[0], start) < Math.min(o[1], end)) return false;
            }
            for(int[] c : calendar){
                if(Math.max(c[0], start) < Math.min(c[1], end)){
                    overlap.add(new int[]{Math.max(c[0], start), Math.min(c[1], end)});
                }
            }
            calendar.add(new int[]{start, end});
            return true;
        }
    }