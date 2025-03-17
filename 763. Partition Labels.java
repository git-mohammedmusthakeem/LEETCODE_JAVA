class Solution {
      public List<Integer> partitionLabels(String S) {
          int len = S.length();
          char[] arr = S.toCharArray();
          int cur = 0, last = 0, temp = 0, count = 0;
          Map<Character, Integer> map = findLast(arr);
          List<Integer> result = new ArrayList<>();
          while(cur < len){
              last = map.get(arr[cur]);
              temp = cur;
              while(temp < last){
                  last = Math.max(last, map.get(arr[++temp]));
              }
              result.add(last - cur + 1);
              cur = last + 1;
          }
          return result;
      }
      private Map<Character, Integer> findLast(char[] arr){
          Map<Character, Integer> map = new HashMap<>();
          for(int i = arr.length - 1; i >= 0; i--){
              if(map.containsKey(arr[i])) continue;
              map.put(arr[i], i);
          }
          return map;
      }
  }