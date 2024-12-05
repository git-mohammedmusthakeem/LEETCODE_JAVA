 public int read(char[] buf, int n) {
            int read = 0;
            int index = 0;
            while(read < n){
                char[] buffer = new char[4];
                int cnt = read4(buffer);
                if(cnt < 4 && read + cnt <= n){
                    for(int i = 0; i < cnt; i++){
                        buf[index++] = buffer[i];
                    }
                    return read + cnt;
                }else if(cnt == 4 && read + cnt < n){
                    for(int i = 0; i < 4; i++){
                        buf[index++] = buffer[i];
                    }
                    read += 4;
                }else if(read + cnt >= n){
                    while(index < n){
                        buf[index] = buffer[index - read];
                        index++;
                    }
                    return n;
                }
            }
            return n;
        }
    }