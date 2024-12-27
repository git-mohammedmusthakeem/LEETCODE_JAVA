class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> it = null;
    LinkedList<Integer> record = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.it = iterator;
        record = new LinkedList<>();
        while(it.hasNext()){
            int num = it.next();
            this.record.add(num);
        }
	}
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return record.get(0);
	}
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return record.poll();
	}
	@Override
	public boolean hasNext() {
	    return this.record.size() > 0;
	}
}