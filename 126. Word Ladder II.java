class Solution {
		private Map<String, List<String>> map;
		public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
			List<List<String>> result = new LinkedList<>();
			Set<String> words = new HashSet<>(wordList);
			if(!words.contains(endWord)) return result;
			words.remove(beginWord);
			LinkedList<String> queue = new LinkedList<>();
			map = new HashMap<>();
			int len = beginWord.length();
			boolean found = false;
			queue.add(beginWord);
			while(!queue.isEmpty() && !found){
				int size = queue.size();
				Set<String> curLevel = new HashSet<>();
				for(int i = 0; i < size; i++){
					String cur = queue.poll();
					if(cur.equals(endWord)) found = true;   
					char[] arr = cur.toCharArray();
					for(int l = 0; l < len; l++){
						for(char c = 'a'; c <= 'z'; c++){
							if(c == cur.charAt(l)) continue;
							arr[l] = c;
							String next = new String(arr);
							if(words.contains(next) || curLevel.contains(next)){
								map.put(cur, !map.containsKey(cur) ? new ArrayList<String>(): map.get(cur));
								map.get(cur).add(next);
								curLevel.add(next);
								if(words.contains(next)) queue.offer(next);
								words.remove(next);
							}
						}
						arr[l] = cur.charAt(l);
					}
				}
			}
			List<String> temp = new LinkedList<>();
			temp.add(beginWord);
			dfs(result, temp, endWord, beginWord);
			return result;
		}
		private void dfs(List<List<String>> result, List<String> temp, String endWord, String cur){
			if(cur.equals(endWord)){
				result.add(new ArrayList<>(temp));
			}else{
				if(!map.containsKey(cur)) return;
				List<String> adj = map.get(cur);
				for(String s: adj){
					temp.add(s);
					dfs(result, temp, endWord, s);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}