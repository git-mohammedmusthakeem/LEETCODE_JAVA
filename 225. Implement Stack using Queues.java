class MyStack {
    LinkedList<Integer> stack = null;
    int size = 0;
    public MyStack() {
        stack = new LinkedList<>();
    }
    public void push(int x) {
        this.stack.addFirst(x);
        this.size++;
    }
    public int pop() {
        this.size --;
        return this.stack.pollFirst();
    }
    public int top() {
        return this.stack.get(0);
    }  
    public boolean empty() {
        return this.size == 0;
    }
}