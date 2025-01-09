class Solution {
		public List<Integer> topKFrequent(int[] nums, int k) {
			List<Integer> result = new ArrayList<>();
			if(nums == null || nums.length == 0) return result;
			Map<Integer, Integer> map = new HashMap<>();
			int max = 1, freqMax = 0;
			for(int n : nums){
				max = Math.max(max, n);
				map.put(n, map.getOrDefault(n, 0) + 1);
				freqMax = Math.max(freqMax, map.get(n));
			}
			List[] arr = new List[freqMax + 1];
			for(Map.Entry<Integer, Integer> entry : map.entrySet()){
				int freq = entry.getValue();
				if(arr[freq] == null) arr[freq] = new ArrayList<>();
				arr[freq].add(entry.getKey());
			}
			for(int i = arr.length - 1; i >= 0 && k > 0; i--){
				if(arr[i] == null) continue;
				result.addAll(arr[i]);
				k -= arr[i].size();
			}
			return result;
		}
	}