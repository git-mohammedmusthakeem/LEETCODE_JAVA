class Solution {
        public String nearestPalindromic(String n) {
            char[] arr = n.toCharArray();
            int left = 0, right = arr.length - 1;
            while(left < right) arr[right--] = arr[left++];
            String palindromeString = new String(arr);
            String preString = findPalindrome(palindromeString, true);
            String postString = findPalindrome(palindromeString, false);
            
            long original = Long.parseLong(n);
            long palindrome = Long.parseLong(palindromeString);
            long pre = Long.parseLong(preString);
            long post = Long.parseLong(postString);
            
            long d1 = Math.abs(original - pre);
            long d2 = Math.abs(original - palindrome);
            long d3 = Math.abs(original - post);
            
            if(original == palindrome){
                return d1 <= d3 ? preString: postString;   
            }else if(original > palindrome){
                return d2 <= d3 ? palindromeString: postString;
            }else{
                return d1 <= d2 ? preString: palindromeString;
            }
        }
        private String findPalindrome(String s, boolean isPre){
            int k = s.length() >> 1, p = s.length() - k;
            int l = Integer.parseInt(s.substring(0, p));
            l += isPre ? -1: 1;
            if(l == 0) return k == 0 ? "0": "9";
            String left = "" + l;
            String right = new StringBuilder(left).reverse().toString();
            if(k > left.length()) right += "9";
            return left + right.substring(right.length() - k);
        }
    }