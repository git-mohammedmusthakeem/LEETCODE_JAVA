class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() <= 10) return result;
        int len = s.length();
        LABEL:
        for(int i = 0; i <= len - 11; i++){
            String cmp = s.substring(i, i + 10);
            if(result.contains(cmp)) continue;
            for(int j = i + 1; j <= len - 10; j++){
                String cmp1 = s.substring(j, j + 10);
                if(cmp.equals(cmp1)){
                    result.add(cmp);
                    continue LABEL;
                }
            }
        }
        return result;
    }
}