class Solution {
      public int openLock(String[] deadends, String target) {
          HashSet<String> set = new HashSet<>();
          for(String s : deadends) set.add(s);
          if(set.contains(target) || set.contains("0000")) return -1;
          LinkedList<String> queue = new LinkedList<>();
          queue.add("0000");
          int len = target.length(), step = -1;
          Set<String> visited = new HashSet<>();
          while(!queue.isEmpty()){
              ++step;
              int size = queue.size();
              for(int i = 0; i < size; i++){
                  String cur = queue.poll();
                  if(cur.equals(target)) return step;
                  char[] arr = cur.toCharArray();
                  for(int l = 0; l < len; l++){
                      String next = null;
                      // 1. Add 1
                      arr[l] = arr[l] == '9' ? '0': (char)(arr[l] + 1);
                      next = new String(arr);
                      if(!set.contains(next) && !visited.contains(next)){
                          queue.add(next);
                          visited.add(next);
                      }
                      // 2. Deduct 1
                      arr[l] = cur.charAt(l) == '0' ? '9': (char)(cur.charAt(l) - 1);
                      next = new String(arr);
                      if(!set.contains(next) && !visited.contains(next)){
                          queue.add(next);
                          visited.add(next);
                      }
                      arr[l] = cur.charAt(l);
                  }
              }
          }
          return -1;
      }
  }