class Solution {
		public List<String> restoreIpAddresses(String s) {
			List<String> result = new ArrayList<>();
			if(s == null || s.length() < 4) return result;
			dfs(result, new StringBuilder(), 0, s, 0);
			return result;
		}
		private void dfs(List<String> result, StringBuilder sb, int start, String s, int count){
			if(start == s.length() && count == 4){
				sb.deleteCharAt(sb.length() - 1);
				result.add(sb.toString());
			}else if(count < 4){
				for(int i = start + 1; (i <= start + 3) && (i <= s.length()); i++){
					String sub = s.substring(start, i);
					if(sub.charAt(0) == '0' && sub.length() != 1) return;
					int cur = Integer.parseInt(sub);
					if(cur >= 0 && cur <= 255){
						int temp = sb.length();
						sb.append(cur + ".");
						dfs(result, sb, i, s, count + 1);
						sb.delete(temp, sb.length());
					}
				}
			}
		}
	}