class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        result.add(temp);
        if(numRows == 1){
            return result;
        }else{
            generate(numRows, result);
        }
        return result;
    }
    private static void generate(int n, List<List<Integer>> result){
        if(n == 2){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            temp.add(1);
            result.add(temp);
        }else{
            generate(n - 1, result);
            List<Integer> last = result.get(n - 2);
            List<Integer> add = new ArrayList<>();
            add.add(1);
            for(int i = 1; i < n - 1; i++){
                add.add(last.get(i - 1) + last.get(i));
            }
            add.add(1);
            result.add(add);
        }
    }
}