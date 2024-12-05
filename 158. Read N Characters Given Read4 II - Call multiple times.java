public int read(char[] buf, int n) {
            if(s == null){
                s = "";
                char[] buffer = new char[4];
                int cnt = 0;
                while((cnt = read4(buffer)) != 0){
                    for(int i = 0; i < cnt; i++)
                        s += buffer[i];
                }
            }
            if(index >= s.length()) return 0;
            if(index + n <= s.length()){
                String sub = s.substring(index, index + n);
                for(int i = 0; i < n; i++){
                    buf[i] = sub.charAt(i);
                }
                index += n;
                return n;
            }else{
                for(int i = index; i < s.length(); i++){
                    buf[i - index] = s.charAt(i);
                }
                int res = s.length() - index;
                index = s.length();
                return res;
            }
        }
    }