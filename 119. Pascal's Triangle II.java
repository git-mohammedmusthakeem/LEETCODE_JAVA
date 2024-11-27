class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        getRow(rowIndex, list);
        return list;
    }
    private static void getRow(int rowIndex, List<Integer> list){
        if(rowIndex == 0){
            list.add(1);
        }else if(rowIndex == 1){
            list.add(1);
            list.add(1);
        }else{
            getRow(rowIndex - 1, list);
            int len = list.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for(int i = 0; i < len - 1; i++){
                temp.add(list.get(i) + list.get(i + 1));
            }
            list.clear();
            list.add(1);
            list.addAll(temp);
            list.add(1);
        }
    }
}