class Solution {
        public List<String> addOperators(String num, int target) {
            List<String> result = new ArrayList<>();
            dfs(result, num, "", 0, 0, 0, target);
            return result;
        }
        private void dfs(List<String> result, String num, String prefix, int index, long pre, long cur, int target){
            if(index == num.length() && cur == target){
                result.add(prefix);
            }
            for(int i = index; i < num.length(); i++){
                if(i != index && num.charAt(index) == '0') break;
                long temp = Long.parseLong(num.substring(index, i + 1));
                if(index == 0){
                    dfs(result, num, "" + temp, i + 1, temp, temp, target);
                }else{
                    dfs(result, num, prefix + "+" + temp, i + 1, temp, cur + temp, target);
                    dfs(result, num, prefix + "-" + temp, i + 1, -temp, cur - temp, target);
                    dfs(result, num, prefix + "*" + temp, i + 1, pre * temp, cur - pre + pre * temp, target);
                }
            }
        }
    }