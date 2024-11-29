class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> q = new LinkedList<>();
        if(!wordList.contains(endWord)) return 0;
        q.add(beginWord);
        int count = 0;
        while(!q.isEmpty()){
            count++;
            for(int i = 0; i < q.size(); i++){
                String current = q.poll();
                if(current.equals(endWord)) return count;
                char[] arr = current.toCharArray();
                for(int j = 0; j < arr.length; j++){
                    for(char a = 'a'; a <= 'z'; a++){
                        char tempChar = arr[j];
                        if(a == tempChar) continue;
                        arr[j] = a;
                        String temp = String.valueOf(arr);
                        if(wordList.contains(temp)){
                            q.add(temp);
                            wordList.remove(temp);
                        }
                        arr[j] = tempChar;
                    }
                }
            }
        }
        return 0;
    }
}