public class NestedIterator implements Iterator<Integer> {
    private LinkedList<Integer> list;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new LinkedList<>();
        addList(nestedList);
    }
    private void addList(List<NestedInteger> list){
        for(NestedInteger num : list){
            if(num.isInteger()){
                this.list.add(num.getInteger());
            }else
                addList(num.getList());
        }
    }

    @Override
    public Integer next() {
        return this.list.poll();
    }

    @Override
    public boolean hasNext() {
        return !this.list.isEmpty();
    }
}