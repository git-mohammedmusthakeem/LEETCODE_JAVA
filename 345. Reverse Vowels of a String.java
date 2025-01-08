class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.trim().length() == 0) return s;
        Set<Character> set = new HashSet<>();
        set.addAll(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        char[] arr = s.toCharArray();
        int low = 0, high = arr.length - 1;
        int len = arr.length;
        while(true){
            while(!set.contains(arr[low])) if(++low >= len) break;
            while(!set.contains(arr[high])) if(--high < 0) break;
            if(low >= high) break;
            swap(arr, low++, high--);
        }
        return new String(arr);
    }
    private void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}