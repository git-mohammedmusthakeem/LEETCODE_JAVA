class MinStack {
    private LinkedList<Integer> stack;
    public MinStack() {
        this.stack = new LinkedList<Integer>();
    }
    public void push(int x) {
        this.stack.addFirst(x);
    }
    public void pop() {
        this.stack.removeFirst();
    }
    public int top() {
        return this.stack.get(0);
    }
    public int getMin() {
        int min = this.stack.get(0);
        ListIterator<Integer> it = this.stack.listIterator(0);
        while(it.hasNext())
            min = Math.min(min, it.next());
        return min;
    }
}