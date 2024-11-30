class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        if(s == null) return result;
        backtrace(s, result, new LinkedList<String>(), 0);
        return result;
    }
    private void backtrace(String s, List<List<String>> result, List<String> temp, int index){
        if(index == s.length()) result.add(new LinkedList<String>(temp));
        else{
            for(int i = index + 1; i <= s.length(); i++){
                String cur = s.substring(index, i);
                if(isPalindrome(cur)){
                    temp.add(cur);
                    backtrace(s, result, temp, i);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
    private boolean isPalindrome(String s){
        int len = s.length();
        if(len == 0) return true;
        int low = -1, high = len;
        char[] arr = s.toCharArray();
        while(low <= high){
            if(++low < len && --high >= 0)
                if(arr[low] != arr[high])
                    return false;
        }
        return true;
    }
}