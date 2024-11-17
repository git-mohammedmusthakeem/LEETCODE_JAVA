class Solution {
    public String addBinary(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        int carry = 0, aIndex = aArr.length - 1, bIndex = bArr.length - 1;
        StringBuilder sb = new StringBuilder();
        while(aIndex >= 0 || bIndex >= 0){
            if(aIndex >= 0 && bIndex >= 0){
                sb.append(((aArr[aIndex] - '0') + (bArr[bIndex] - '0') + carry) % 2);
                carry = ((aArr[aIndex--] - '0') + (bArr[bIndex--] - '0') + carry) / 2;
            }else if(aIndex >= 0 && bIndex < 0){
                sb.append(((aArr[aIndex] - '0') + carry) % 2);
                carry = (aArr[aIndex--] - '0' + carry) / 2;
            }else{
                sb.append(((bArr[bIndex] - '0') + carry) % 2);
                carry = (bArr[bIndex--] - '0' + carry) / 2;
            }
        }
        if(carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}