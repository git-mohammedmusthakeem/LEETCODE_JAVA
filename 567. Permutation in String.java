class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s2.length() < s1.length()) return false;
        List<String> result = new ArrayList<>();
        backtrace(s1, s1.length() - 1, result);
        for(String ss : result){
            System.out.println(ss);
            if(s2.contains(ss))
                return true;
        }
        return false;
    }
    private static void backtrace(String s, int index, List<String> result){
        if(index == -1){
            result.add("");
        }else{
            backtrace(s, index - 1, result);
            char c = s.charAt(index);
            List<String> temp = new ArrayList<>();
            for(String ss:result){
                int len = ss.length();
                for(int i = 0; i <= len; i++)
                    temp.add(insert(ss, c, i));
            }
            result.clear();
            result.addAll(temp);
        }
    }
    private static String insert(String s, char c, int pos){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < pos; i++)
            sb.append(s.charAt(i));
        sb.append(c);
        for(int i = pos; i < s.length(); i++)
            sb.append(s.charAt(i));
        return sb.toString();
    }
}