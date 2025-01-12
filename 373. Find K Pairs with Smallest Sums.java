class Solution {
        public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<int[]> result = new ArrayList<>();
            if(nums1.length == 0 || nums2.length == 0 || k == 0) return result;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
                return a[0] + a[1] - b[0] - b[1];
            });
            //[0]: number from first arr
            //[1]: number from second arr
            //[2]: index of number in second arr
            for(int i = 0; i < nums1.length; i++) pq.offer(new int[]{nums1[i], nums2[0], 0}); 
            while(k-- > 0 && !pq.isEmpty()){
                int[] cur = pq.poll();
                result.add(new int[]{cur[0], cur[1]});
                if(cur[2] + 1 == nums2.length) continue;
                pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
            }
            return result;
        }
    }