class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] mask = new int[len];
        int res = 0;
        for(int i = 0; i < len; i++){
            char[] arr = words[i].toCharArray();
            for(int j = 0; j < arr.length; j++){
                int c = arr[j] - 'a';
                mask[i] |= 1 << c;
            }
        }
        for(int i = 0; i < len - 1; i++){
            for(int j = i + 1; j < len; j++){
                if((mask[i] & mask[j]) == 0)
                    res = Math.max(res, words[i].length() * words[j].length());
            }
        }
        return res;
    }
}