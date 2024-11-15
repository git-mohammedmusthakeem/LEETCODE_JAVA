class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int size = intervals.size();
        List<Interval> result = new LinkedList<>();
        if(size == 0) return result;
        int[] up = new int[size];
        for(int i = 0; i < size; i++)
            up[i] = intervals.get(i).start;
        int[] down = new int[size];
        for(int i = 0; i < size; i++)
            down[i] = intervals.get(i).end;
        Arrays.sort(up);
        Arrays.sort(down);
        int begin = up[0];
        for(int i = 1; i < size; i++){
            if(up[i] > down[i - 1]){
                result.add(new Interval(begin, down[i - 1]));
                begin = up[i];
            }
        }
        result.add(new Interval(begin, down[size - 1]));
        return result;
    }
}