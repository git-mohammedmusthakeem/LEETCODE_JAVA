class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return null;
        int len = digits.length;
        int[] result = new int[len + 1];
        int carry = 1;
        for(int i = len - 1; i >= 0; i--){
            int current = digits[i] + carry;
            result[i + 1] = current % 10;
            carry = current / 10;
        }
        if(carry == 1){
            result[0] = carry;
            return result;
        }
        return Arrays.copyOfRange(result, 1, len + 1);
    }
}