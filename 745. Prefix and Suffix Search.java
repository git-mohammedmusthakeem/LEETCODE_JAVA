class WordFilter {
        private String[] words;
        public WordFilter(String[] words) {
            this.words = words;
        }
        public int f(String prefix, String suffix) {
            int res = -1;
            for(int i = 0; i < this.words.length; i++){
                if(words[i].startsWith(prefix) && words[i].endsWith(suffix)){
                    res = Math.max(res, i);
                }
            }
            return res;
        }
    }