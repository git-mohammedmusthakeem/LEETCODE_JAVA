class Solution {
        private static Random random = new Random();
        private int[] w;
        private int sum;
        public Solution(int[] w) {
            this.w = w;
            for(int num : w) this.sum += num;
        }
        
        public int pickIndex() {
            int rand = random.nextInt(sum) + 1;
            int temp = 0;
            for(int i = 0; i < w.length; i++){
                if(temp + w[i] >= rand) return i;
                temp += w[i];
            }
            return w.length - 1;
        }
    }