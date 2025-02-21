class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {    //O(NlogN)
            return construct(nums, 0, nums.length);
        }
        private TreeNode construct(int[] nums, int low, int high){  // O(logN)
            if(low >= high) return null;
            int mid = findMax(nums, low, high);
            TreeNode node = new TreeNode(nums[mid]);
            node.left = construct(nums, low, mid);
            node.right = construct(nums, mid + 1, high);
            return node;
        }
        private int findMax(int[] nums, int low, int high){ // O(n)
            int index = -1, max = Integer.MIN_VALUE;
            for(int i = low; i < high; i++){
                if(nums[i] > max){
                    index = i;
                    max = nums[i];
                }
            }
            return index;
        }
    }