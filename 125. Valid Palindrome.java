class Solution {
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int len = s.length();
        if(len == 0) return true;
        int head = 0, end = s.length() - 1;
        char[] arr = s.toCharArray();
        while(head < end){
            while(!isAlphanumeric(arr[head])){
                if(head + 1 >= len) return true;
                head++;
            }
            while(!isAlphanumeric(arr[end])){
                if(end - 1 < 0) return true;
                end--;
            }
            if(head > end) return true;
            if(arr[head++] != arr[end--]) return false;
        }
        return true;
    }
    public boolean isAlphanumeric(char c) {
		if ((c >=48 && c <=57) || (c >= 97 && c <= 122)) return true;
		return false;
	}
}