class Solution {
    int count = 0;
    public String getPermutation(int n, int k) {
        List<String> result = new LinkedList<>();
        backtrace(result, new StringBuilder(), n, k, new boolean[n + 1]);
        return result.get(0);
    }
    private void backtrace(List<String> result, StringBuilder sb, int n, int k, boolean[] used){
        if(count >= k) return;
        if(sb.toString().length() == n){
            if(++count == k)
                result.add(sb.toString());
        }else{
            for(int i = 1; i <= n; i++){
                if(!used[i]){
                    sb.append(i);
                    used[i] = true;
                    backtrace(result, sb, n, k, used);
                    used[i] = false;
                    sb.deleteCharAt(sb.toString().length() - 1);
                }
            }
        }
    }
}