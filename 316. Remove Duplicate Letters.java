class Solution {
        public String removeDuplicateLetters(String s) {
            int[] count = new int[26];
            char[] arr = s.toCharArray();
            for(char c: arr) count[c - 'a']++;
            boolean[] visited = new boolean[26];
            // Deque increasing.
            Deque<Character> dq = new LinkedList<>();
            for(char c : arr){
                count[c - 'a']--;   // remove the frequency of current letter.
                if(visited[c - 'a']) continue;  // means current character has already in the dq.
                // !dq.isEmpty(): Means current dq is not empty
                // dq.peekLast() > c: the end character in the dq has larger lexicographical order than c.
                // count[dq.peekLast() - 'a'] > 0: if end letter is at the last time appearence, it means we cannot remove it.
                while(!dq.isEmpty() && dq.peekLast() > c && count[dq.peekLast() - 'a'] > 0){
                    visited[dq.pollLast() - 'a'] = false;
                }
                visited[c - 'a'] = true;
                dq.offer(c);
            }
            StringBuilder sb = new StringBuilder();
            while(!dq.isEmpty()){
                sb.append(dq.poll());
            }
            return sb.toString();
        }
    }