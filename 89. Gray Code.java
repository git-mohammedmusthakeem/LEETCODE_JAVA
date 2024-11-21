class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = null;
        if(n == 0){
            result = new LinkedList<>();
            result.add(0);
        }else{
            List<String> temp = new LinkedList<>();
            backtrace(temp, n);
            result = getResult(temp);
        }
        return result;
    }
    private void backtrace(List<String> temp, int index){
        if(index == 1){
            temp.addAll(Arrays.asList("0", "1"));
        }else{
            backtrace(temp, index - 1);
            int size = temp.size();
            List<String> save = new LinkedList<>();
            for(int i = 0; i < size; i++)
                temp.add(temp.get(size - 1 - i));
            for(int i = 0; i < size; i++)
                save.add("0" + temp.get(i));
            for(int i = size; i < 2 * size; i++)
                save.add("1" + temp.get(i));
            temp.clear();
            temp.addAll(save);
        }
        
    }
    private List<Integer> getResult(List<String> res){
        int size = res.size();
        List<Integer> result = new LinkedList<>();
        for(String ss : res)
            result.add(stringToInteger(ss));
        return result;
    }
    private Integer stringToInteger(String s){
        char[] arr = s.toCharArray();
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            res *= 2;
            res += arr[i] - '0';
        }
        return res;
    }
}