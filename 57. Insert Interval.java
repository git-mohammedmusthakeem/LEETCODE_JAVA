class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int size = intervals.size();
        List<Interval> result = new LinkedList<>();
        if(size == 0){
            result.add(newInterval);
            return result;
        }
        int[] up = new int[size + 1];
        for(int i = 0; i < size; i++)
            up[i] = intervals.get(i).start;
        up[size] = newInterval.start;
        int[] down = new int[size + 1];
        for(int i = 0; i < size; i++)
            down[i] = intervals.get(i).end;
        down[size] = newInterval.end;
        Arrays.sort(up);Arrays.sort(down);
        int begin = up[0];
        for(int i = 1; i < size + 1; i++){
            if(up[i] > down[i - 1]){
                result.add(new Interval(begin, down[i - 1]));
                begin = up[i];
            }
        }
        result.add(new Interval(begin, down[size]));
        return result;
    }
}