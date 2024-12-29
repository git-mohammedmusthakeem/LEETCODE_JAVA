class MedianFinder {
    /** initialize your data structure here. */
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer n1, Integer n2){
                return n2 - n1;
            }
        });
    }
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if(max.size() < min.size()) max.offer(min.poll());
    }
    public double findMedian() {
        if(max.size() > min.size()) return (double)max.peek();
        else return (double)(max.peek() + min.peek()) / 2;
    }
}