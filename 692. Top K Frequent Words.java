class Solution {
      private static class Pair{
          String s;
          int count;
          public Pair(String s, int count){
              this.s = s;
              this.count = count;
          }
      }
      public List<String> topKFrequent(String[] words, int k) {
          TreeMap<String, Integer> treeMap = new TreeMap<>(new Comparator<String>(){  //time complexity: O(nlogN)
              @Override
              public int compare(String a, String b){
                  return a.compareTo(b);
              }
          });
          for(String word : words){
              treeMap.put(word, treeMap.getOrDefault(word, 0) + 1);
          }

          PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){    //time complexity: O(nlogN)
              @Override
              public int compare(Pair p1, Pair p2){
                  return p2.count == p1.count ? p1.s.compareTo(p2.s) : p2.count - p1.count;
              }
          });
          for(Map.Entry<String, Integer> entry : treeMap.entrySet()){
              pq.offer(new Pair(entry.getKey(), entry.getValue()));
          }
          List<String> result = new ArrayList<>();
          for(int i = 0; i < k; i++){
              result.add(pq.poll().s);
          }        
          return result;
      }
  }