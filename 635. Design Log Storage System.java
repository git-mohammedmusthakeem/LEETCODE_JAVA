class LogSystem {
        private Map<String, Integer> map;
        private static final Map<String, Integer> g;
        private static final String token = "00";
        static{
            g = new HashMap<>();
            g.put("Year", 4);
            g.put("Month", 7);
            g.put("Day", 10);
            g.put("Hour", 13);
            g.put("Minute", 16);
            g.put("Second", 19);
        }
        public LogSystem() {
            this.map = new HashMap<>();
        }
        
        public void put(int id, String timestamp) {
            map.put(timestamp, id);
        }
        
        public List<Integer> retrieve(String s, String e, String gra) {
            int index = g.get(gra);
            String ssub = s.substring(0, index);
            String esub = e.substring(0, index);
            List<Integer> result = new ArrayList<>();
            for(String k : map.keySet()){
                String ksub = k.substring(0, index);
                if(ksub.compareTo(ssub) >= 0 && ksub.compareTo(esub) <= 0)
                    result.add(map.get(k));
            }
            return result;
        }
    }