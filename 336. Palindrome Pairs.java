class Solution {
        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> res = new ArrayList<>();
            if(words == null || words.length < 2) return res;
            Map<String, Integer> map = new HashMap<>();
            for(int i = 0; i < words.length; i++){  // O(N)
                map.put(words[i], i);
            }
            for(int i = 0; i < words.length; i++){  // O(N * k)
                for(int j = 0; j <= words[i].length(); j++){
                    String first = words[i].substring(0, j);
                    String second = words[i].substring(j);
                    if(isPalindrome(first)){    // O(k)
                        //first is palindrome, check if we have reverse of second
                        String reverse = new StringBuilder(second).reverse().toString();
                        if(map.containsKey(reverse) && map.get(reverse) != i){
                            List<Integer> temp = new ArrayList<>();
                            temp.add(map.get(reverse));
                            temp.add(i);
                            res.add(temp);
                        }
                    }
                    if(second.length() != 0 && isPalindrome(second)){   // O(k)
                        String reverse = new StringBuilder(first).reverse().toString();
                        if(map.containsKey(reverse) && map.get(reverse) != i){
                            List<Integer> temp = new ArrayList<>();
                            temp.add(i);
                            temp.add(map.get(reverse));
                            res.add(temp);
                        }
                    }
                }
            }
            return res;
        }
        private boolean isPalindrome(String s){
            int left = 0, right = s.length() - 1;
            char[] arr = s.toCharArray();
            while(left < right){
                if(arr[left++] != arr[right--])
                    return false;
            }
            return true;
        }
    }