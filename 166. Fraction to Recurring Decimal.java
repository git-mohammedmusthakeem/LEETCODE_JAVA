class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return "NaN";
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        if(numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0) sb.append('-');
        long aa = Math.abs((long)numerator);
        long bb = Math.abs((long)denominator);
        long digit = aa / bb;
        sb.append(digit);
        long remain = aa % bb;
        if(remain == 0) return sb.toString();
        sb.append(".");
        int count = 1;
        while(remain != 0 && !map.containsKey(remain *10)){
            remain *= 10;
            map.put(remain, count++);
            sb.append(Math.abs(remain / bb));
            remain %= bb;
        }
        if(remain != 0){
            sb.append(")");
            int val = map.get(remain * 10);
            String result = sb.toString();
            int index = result.indexOf('.');
            sb.insert(val + index, '(');
        }
        return sb.toString();
    }
}