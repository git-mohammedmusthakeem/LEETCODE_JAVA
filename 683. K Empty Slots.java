class Solution {
        public int kEmptySlots(int[] flowers, int k) {
            if(flowers == null || flowers.length == 0) return -1;
            TreeSet<Integer> set = new TreeSet<>();
            for(int i = 0; i < flowers.length; i++){
                Integer higher = set.higher(flowers[i]);
                if(higher != null && higher - flowers[i] == k + 1) return i + 1;
                Integer lower = set.lower(flowers[i]);
                if(lower != null && flowers[i] - lower == k + 1) return i + 1;
                set.add(flowers[i]);
            }
            return -1;
        }
    }