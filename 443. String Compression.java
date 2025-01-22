class Solution {
        public int compress(char[] chars) {
            int count = 0;
            int read = 0;
            while(read < chars.length){
                char c = chars[read];
                int check = read;
                while(check < chars.length && chars[check] == c){
                    check++;
                }
                // c appears check - read times.
                chars[count++] = c;
                if(check - read > 1){
                    String num = "" + (check - read);
                    for(int i = 0; i < num.length(); i++){
                        chars[count++] = num.charAt(i);
                    }
                }
                read = check;
            }
            return count;
        }
    }