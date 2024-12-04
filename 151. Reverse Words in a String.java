public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        String[] arr = s.split(" ");
        int len = arr.length;
        if(len == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(arr[len - 1]);
        for(int i = len - 2; i >= 0; i--)
            if(arr[i].length() > 0)
                sb.append(" " + arr[i]);
        return sb.toString();
    }
}