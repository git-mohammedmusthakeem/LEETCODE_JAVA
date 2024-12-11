class Solution {
        public void reverseWords(char[] str) {
            String s = new String(str);
            String[] tokens = s.split(" ");
            int count = 0;
            for(int i = tokens.length - 1; i >= 0; i--){
                for(char c : tokens[i].toCharArray()){
                    str[count++] = c;
                }
                if(count < str.length)
                    str[count++] = ' ';
            }
        }
    }