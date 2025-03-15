class Solution {
        private int[] heights;
        public int[] pourWater(int[] heights, int V, int K) {
            this.heights = heights;
            while(V > 0){
                drop(K);
                V--;
            }
            return this.heights;
        }
        private void drop(int k){
            int pos = k - 1;
            int cur = heights[k];
            while(pos >= 0){
                if(heights[pos] < cur){
                    drop(pos);
                    return;
                }else if(heights[pos] > cur) break;
                pos--;
            }
            pos = k + 1;
            while(pos < heights.length){
                if(heights[pos] < heights[k]){
                    drop(pos);
                    return;
                }else if(heights[pos] > cur) break;
                pos++;
            }
            this.heights[k]++;
        }
    }