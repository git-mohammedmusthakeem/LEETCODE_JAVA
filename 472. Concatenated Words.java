class Solution {
		public List<String> findAllConcatenatedWordsInADict(String[] words) {
			List<String> result = new ArrayList<>();
			Arrays.sort(words, new Comparator<String>(){
				@Override
				public int compare(String a, String b){
					return a.length() - b.length();
				}
			});
			Set<String> checked = new HashSet<>();
			for(String word: words){
				if(canForm(word, checked)){
					result.add(word);
				}
				checked.add(word);
			}
			return result;
		}
		private boolean canForm(String word, Set<String> set){
			if(set.isEmpty()) return false;
			int len = word.length();
			boolean[] dp = new boolean[len + 1];
			dp[0] = true;
			LABEL:
			for(int i = 1; i <= len; i++){
				for(int j = 0; j < i; j++){
					if(set.contains(word.substring(j, i))){
						dp[i] |= dp[j];
					}
					if(dp[i]) break;
				}
			}
			return dp[len];
		}
	}