class Solution {
        private int expect; // total length of result.
        private int k;
        private int n;
        public String crackSafe(int n, int k) {
            this.expect = (int)Math.pow((double)k, (double)n) + n - 1;
            this.k = k;
            this.n = n;
            StringBuilder res = new StringBuilder();
            for(int i = 0; i < n; i++) res.append(0);
            Set<String> visited = new HashSet<>();
            visited.add(res.toString());
            dfs(res, visited);
            return res.toString();
        }
        private boolean dfs(StringBuilder sb, Set<String> visited){
            if(sb.length() == expect) return true;
            // sb currently saves the string and we will reuse last n - 1 characters.
            String pre = sb.substring(sb.length() - n + 1);
            for(char c = '0'; c < '0' + k; c++){
                String current = pre + c;
                if(visited.contains(current)) continue;
                visited.add(current);
                sb.append(c);
                if(dfs(sb, visited)) return true;
                sb.deleteCharAt(sb.length() - 1);
                visited.remove(current);
            }
            return false;
        }
    }