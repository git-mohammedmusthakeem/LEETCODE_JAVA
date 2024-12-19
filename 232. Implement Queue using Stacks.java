class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    /** Initialize your data structure here. */
    public MyQueue() {
        st1 = new Stack<Integer>();
        st2 = new Stack<Integer>();
    }

    public void push(int x) {
        if(st1.isEmpty()){
            int size = st2.size();
            for(int i = 0; i < size; i++)
                st1.push(st2.pop());
        }
        st1.push(x);
    }
    public int pop() {
        if(st2.isEmpty()){
            int size = st1.size();
            for(int i = 0; i < size; i++)
                st2.push(st1.pop());
        }
        return st2.pop();
    }

    public int peek() {
        if(st2.isEmpty()){
            int size = st1.size();
            for(int i = 0; i < size; i++)
                st2.push(st1.pop());
        }
        return st2.peek();
    }

    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}