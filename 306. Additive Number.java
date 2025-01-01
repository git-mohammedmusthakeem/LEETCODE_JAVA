class Solution {
    public boolean isAdditiveNumber(String num) {
        boolean result = false;
        for(int i = 1; i <= num.length() - 2; i++){
            for(int j = i + 1; j <= num.length() - 1; j++){
                if(i != 1 && num.substring(0, i).startsWith("0")) continue;
                if(j - i != 1 && num.substring(i, j).startsWith("0")) continue;
                result |= backtrace(num, Long.parseLong(num.substring(0, i)), Long.parseLong(num.substring(i, j)), j);
            }
        }
        return result;
    }   
    
    private boolean backtrace(String num, long first, long second, int idx){
        if(idx >= num.length()) return true;
        long sum = first + second;
        if(sum != 0 && num.substring(idx).startsWith("0")) return false;
        else{
            boolean temp = false;
            if(num.substring(idx).startsWith("" + sum)){
                temp |= backtrace(num, second, sum, idx + ("" + sum).length());
            }
            return temp;
        }
    }
}