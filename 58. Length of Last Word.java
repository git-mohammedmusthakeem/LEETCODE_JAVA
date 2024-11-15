class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.trim().length() == 0) return 0;
        String[] arr = s.trim().split(" ");
        if(arr.length == 1)  return s.trim().length();
        return arr[arr.length - 1].length();
    }
}