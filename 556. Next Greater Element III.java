class Solution {
        public int nextGreaterElement(int n) {
            String s = n + "";
            char[] arr = s.toCharArray();
            int len = s.length(), i = len - 2;
            for(; i >= 0; i--){
                if(arr[i] < arr[i + 1]) break;
            }
            if(i < 0) return -1;
            for(int j = len - 1; j > i; j--){
                if(arr[j] > arr[i]){
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    break;
                }
            }
            char[] sub = Arrays.copyOfRange(arr, i + 1, len);
            Arrays.sort(sub);
            for(int j = i + 1; j < len; j++){
                arr[j] = sub[j - i - 1];
            }
            long res = Long.parseLong(new String(arr));
            return res > Integer.MAX_VALUE ? -1: (int)res;
        }
    }