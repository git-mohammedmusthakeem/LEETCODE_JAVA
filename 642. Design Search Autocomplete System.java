class AutocompleteSystem {
        private static class Node{
            Map<Character, Node> childs;
            Map<String, Integer> freq;
            boolean isLeaf;
            public Node(){
                this.childs = new HashMap<>();
                this.freq = new HashMap<>();
            }
        }
        private static class Pair{
            String s;
            int count;
            public Pair(String s, int count){
                this.s = s;
                this.count = count;
            }
        }
        private Node root;
        private String search;
        private void add(String s, int count){
            char[] arr = s.toCharArray();
            Node temp = root;
            for(int i = 0; i < arr.length; i++){
                if(!temp.childs.containsKey(arr[i])){
                    temp.childs.put(arr[i], new Node());
                }
                temp = temp.childs.get(arr[i]);
                temp.freq.put(s, temp.freq.getOrDefault(s, 0) + count);
            }
            temp.isLeaf = true;
        }
        public AutocompleteSystem(String[] sentences, int[] times) {
            this.root = new Node();
            this.search = "";
            for(int i = 0; i < times.length; i++){
                add(sentences[i], times[i]);
            }
        }
        
        public List<String> input(char c) {
            if(c == '#'){
                add(search, 1);
                search = "";
                return new ArrayList<>();
            }
            search += c;
            Node temp = root;
            for(char cc : search.toCharArray()){
                if(!temp.childs.containsKey(cc)){
                    return new ArrayList<>();
                }
                temp = temp.childs.get(cc);
            }
            PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
                @Override
                public int compare(Pair p1, Pair p2){
                    return p1.count == p2.count ? p1.s.compareTo(p2.s) : p2.count - p1.count;
                }
            });
            for(Map.Entry<String, Integer> entry : temp.freq.entrySet()){
                pq.offer(new Pair(entry.getKey(), entry.getValue()));
            }
            List<String> res = new ArrayList<>();
            for(int i = 0; i < 3 && !pq.isEmpty(); i++){
                res.add(pq.poll().s);
            }
            return res;
        }
    }