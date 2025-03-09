class Solution {
      private int index;
      public String countOfAtoms(String formula) {
          StringBuilder sb = new StringBuilder();
          Map<String, Integer> res = count(formula);
          for(Map.Entry<String, Integer> entry: res.entrySet()){
              sb.append(entry.getKey());
              int count = entry.getValue();
              if(count != 1)  sb.append(count);
          }
          return sb.toString();
      }
      private TreeMap<String, Integer> count(String formula){
          TreeMap<String, Integer> map = new TreeMap<>();
          while(index < formula.length()){
              if(formula.charAt(index) == '('){
                  index++;
                  TreeMap<String, Integer> temp = count(formula);
                  int count = getCount(formula);
                  for(Map.Entry<String, Integer> entry: temp.entrySet()){
                      String key = entry.getKey();
                      map.put(key, map.getOrDefault(key, 0) + entry.getValue() * count);
                  }
              }else if(formula.charAt(index) == ')'){
                  index++;
                  return map;
              }else{
                  String name = getName(formula);
                  map.put(name, map.getOrDefault(name, 0) + getCount(formula));
              }
          }
          return map;
      }
      private String getName(String s){
          int start = index;
          while(index < s.length() && Character.isLetter(s.charAt(index)) && (index == start || Character.isLowerCase(s.charAt(index)))){
              index++;
          }
          return s.substring(start, index);
      }
      private int getCount(String s){
          int count = 0;
          while(index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9'){
              char c = s.charAt(index);
              index++;
              count = count * 10 + c - '0';
          }
          return count == 0 ? 1: count;
      }
  }