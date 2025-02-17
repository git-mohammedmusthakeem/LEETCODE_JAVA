class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            int[] result = new int[n];
            int startTime = -1;
            int curId = -1;
            Stack<Integer> stack = new Stack<>();
            for(String log: logs){
                String[] tokens = log.split(":");
                int id = Integer.parseInt(tokens[0]);
                int time = Integer.parseInt(tokens[2]);            
                if(tokens[1].equals("start")){
                    if(curId != -1){
                        result[curId] += time - startTime;
                        stack.push(curId);
                    }
                    curId = id;
                    startTime = time;
                }else{  // current log is for ending.
                    result[curId] += time - startTime + 1;
                    if(!stack.isEmpty()){
                        curId = stack.pop();
                        startTime = time + 1;
                    }else{
                        curId = -1;
                        startTime = -1;
                    }
                }
            }
            return result;
        }
    }