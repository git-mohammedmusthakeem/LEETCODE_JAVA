class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        return kmp(haystack, needle);
    }
    private int[] getNext(String pattern){
		char[] arr = pattern.toCharArray();
		int len = pattern.length();
		int[] next = new int[len];
		next[0] = -1;
		for(int i = 1, j = -1; i < len; i++){
			while(j > -1 && arr[j + 1] != arr[i]){
				j = next[j];
			}
			if(arr[i] == arr[j + 1]) j++;
			next[i] = j;
		}
		return next;
	}
	public int kmp(String text, String pattern){
		int[] next = getNext(pattern);
		char[] tArr = text.toCharArray();
		char[] pArr = pattern.toCharArray();
		int tLen = text.length();
		int pLen = pattern.length();
		int j = -1;
		for(int i = 0; i < tLen; i++){
			while(j > -1 && tArr[i] != pArr[j + 1]){
				j = next[j];
			}
			if(tArr[i] == pArr[j + 1]) j++;
			if(j == pLen - 1) return i - pLen + 1;
		}
		return -1;
	}
}