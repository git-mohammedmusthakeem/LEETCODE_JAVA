class Solution {
        public List<List<String>> findDuplicate(String[] paths) {
            Map<String, String> pathMap = new HashMap<>(); //key: content, value:path/filename;
            Map<String, List<String>> resMap = new HashMap<>(); //key: content, value: list of duplicate files.
            for(String path: paths){
                //Need to add them to the pathMap.
                String[] tokens = path.split(" ");
                String dir = tokens[0];
                for(int i = 1; i < tokens.length; i++){
                    int index = tokens[i].indexOf("(");
                    String filename = tokens[i].substring(0, index);
                    String content = tokens[i].substring(index, tokens[i].length() - 1);
                    if(pathMap.containsKey(content)){
                        if(!resMap.containsKey(content)){
                            List<String> dup = new ArrayList<>();
                            dup.add(pathMap.get(content));
                            resMap.put(content, dup);
                        }
                        List<String> dup = resMap.get(content);
                        dup.add(dir + "/" + filename);
                        resMap.put(content, dup);
                    }else{
                        pathMap.put(content, dir + "/" + filename);
                    }
                }
            }
            List<List<String>> result = new ArrayList<>();
            for(List<String> dups : resMap.values()){
                result.add(dups);
            }
            return result;
        }   
    }