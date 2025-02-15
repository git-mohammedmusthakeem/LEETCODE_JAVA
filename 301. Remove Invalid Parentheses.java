class Solution {
		public List<String> removeInvalidParentheses(String s) {
			int left = 0, right = 0;
			char[] arr = s.toCharArray();
			for(int i = 0; i < arr.length; i++){
				if(arr[i] == '(' || arr[i] == ')'){
					if(arr[i] == '(')   left ++;
					else{
						if(left > 0) left --;
						else if(left == 0) right++;
					}
				}
			}
			Set<String> set = new HashSet<>();
			dfs(s, set, left, right, 0);
			List<String> rr = new LinkedList<>();
			if(set.isEmpty()) rr.add("");
			else rr.addAll(set);
			return rr;
		}
		private void dfs(String s, Set<String> result, int left, int right, int index){
			char[] arr = s.toCharArray();
			if(left == 0 && right == 0 && valid(arr)){
				result.add(s);
				return;
			}
			for(int i = index; i < arr.length; i++){
				if(arr[i] != '(' && arr[i] != ')' || (i > 0 && arr[i - 1] == arr[i])) continue;
				if(right > 0 && arr[i] == ')')   dfs(s.substring(0, i) + s.substring(i + 1), result, left, right - 1, i);
				else if(left > 0 && arr[i] == '(') dfs(s.substring(0, i) + s.substring(i + 1), result, left - 1, right, i);
			}
		}
		private boolean valid(char[] arr){
			int count = 0;
			for(int i = 0; i < arr.length; i++){
				if(arr[i] == '(' || arr[i] == ')'){
					if(arr[i] == '(') count++;
					else count --;
					if(count < 0) return false;
				}
			}
			return count == 0;
		}
	}