class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sarr = new int[256];
        int[] tarr = new int[256];
        for(int i = 0; i < 256; i++){
            sarr[i] = -1;
            tarr[i] = -1;
        }
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(sarr[s.charAt(i)] != tarr[t.charAt(i)]) return false;
            sarr[s.charAt(i)] = tarr[t.charAt(i)] = i;
        }
        return true;
    }
}