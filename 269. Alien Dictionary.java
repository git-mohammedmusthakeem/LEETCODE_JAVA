class Solution {
		public String alienOrder(String[] words) {
			Map<Character, Integer> indegree = new HashMap<>(); // key: letter, value: its indegree
			Map<Character, Set<Character>> map = new HashMap<>(); // key: request, value: its childrens
			for(String word: words){
				for(char c : word.toCharArray()){
					indegree.put(c, 0);
				}
			}
			for(int i = 1; i < words.length; i++){
				int minLen = Math.min(words[i].length(), words[i - 1].length());
				char[] arr1 = words[i - 1].toCharArray(), arr2 = words[i].toCharArray();
				for(int j = 0; j < minLen; j++){
					if(arr1[j] != arr2[j]){ //arr1[j] is ahead of arr2[j]
						Set<Character> set = map.getOrDefault(arr1[j], new HashSet<>());
						if(!set.contains(arr2[j])) indegree.put(arr2[j], indegree.get(arr2[j]) + 1);
						set.add(arr2[j]);
						map.put(arr1[j], set);
						break;
					}
				}
			}
			Queue<Character> q = new LinkedList<>();
			for(Map.Entry<Character, Integer> entry: indegree.entrySet()){
				if(entry.getValue() == 0){
					q.offer(entry.getKey());
				}
			}
			StringBuilder sb = new StringBuilder();
			while(!q.isEmpty()){
				char cur = q.poll();
				sb.append(cur);
				if(!map.containsKey(cur)) continue; // current character doesn't have neighbour.
				Set<Character> neighbours = map.get(cur);
				for(char c : neighbours){
					indegree.put(c, indegree.get(c) - 1);
					if(indegree.get(c) == 0) q.offer(c);
				}
			}
			return sb.length() == indegree.size() ? sb.toString(): "";
		}
	}