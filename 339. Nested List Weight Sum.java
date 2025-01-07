class Solution {
        private int sum = 0;
        public int depthSum(List<NestedInteger> nestedList) {
            if(nestedList == null || nestedList.size() == 0) return 0;
            depthSum(nestedList, 1);
            return this.sum;
        }
        private void depthSum(List<NestedInteger> nestedList, int depth){
            List<NestedInteger> next = new ArrayList<>();
            int sum = 0;
            for(NestedInteger num : nestedList){
                if(num.isInteger()) sum += num.getInteger();
                else next.addAll(num.getList());
            }        
            this.sum += depth * sum;
            if(next.size() != 0) depthSum(next, depth + 1);
        }
    }