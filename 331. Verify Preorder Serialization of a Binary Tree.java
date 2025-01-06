class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] tokens = preorder.split(",");
        int len = tokens.length;
        int count = 0;
        for(int i = 0; i < len - 1; i++){
            if(!tokens[i].equals("#")){
                count ++;
            }else{
                count --;
            }
            if(count < 0) return false;
        }
        return count == 0 && tokens[len - 1].equals("#");
    }
}