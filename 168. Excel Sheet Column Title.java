class Solution {
    public String convertToTitle(int n) {
        if(n == 0) return "";
        StringBuilder sb = new StringBuilder();
        String map = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        while(n != 0){
            sb.append(map.charAt((n - 1) % 26));
            n --;
            n /= 26;
        }
        return sb.reverse().toString();
    }
}