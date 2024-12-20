class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int sum = 0;
        int total = 0;
        int index = 0;
        for(int i = 0; i < len; i++){
            sum += gas[i] - cost[i];
            if(sum < 0){
                total += sum;
                sum = 0;
                index = i+1;
            }
        }
        total += sum;
        return (total >= 0) ? index : -1;
    }
}