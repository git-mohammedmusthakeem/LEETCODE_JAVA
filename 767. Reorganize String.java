class Solution {
        private static final class Node{
            char c;
            int f;
            public Node(char c, int f){
                this.c = c;
                this.f = f;
            }
        }
        public String reorganizeString(String S) {
            char[] arr = S.toCharArray();
            int[] table = new int[26];
            for(char c : arr){
                if(++table[c - 'a'] > (S.length() + 1)/ 2) return "";
            }
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
                return b.f - a.f;
            });
            for(int i = 0; i < 26; i++){
                if(table[i] > 0){
                    pq.offer(new Node((char)(i + 'a'), table[i]));
                }
            }
            StringBuilder sb = new StringBuilder();
            while(pq.size() >= 2){
                Node first = pq.poll();
                Node second = pq.poll();
                sb.append(first.c);
                sb.append(second.c);
                if(--first.f > 0) pq.offer(first);
                if(--second.f > 0) pq.offer(second);
            }
            if(!pq.isEmpty()) sb.append(pq.poll().c);
            return sb.toString();
        }
    }