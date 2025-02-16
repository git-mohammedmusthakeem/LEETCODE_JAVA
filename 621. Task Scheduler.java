class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] freq = new int[26];
            for(char c : tasks){
                freq[c - 'A']++;
            }
            Arrays.sort(freq);
            int i = 25;
            while(i >= 0 && freq[i] == freq[25]){i--;}
            return Math.max((n + 1) * (freq[25] - 1) + (25 - i), tasks.length);
        }
    }