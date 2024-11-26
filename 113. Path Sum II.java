class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        pathSum(root, sum, 0, result, new ArrayList<Integer>());
        return result;
    }
    private static void pathSum(TreeNode root, int sum, int count, List<List<Integer>> result, List<Integer> list){
        if(root == null){
            if(count == sum){
                result.add(new ArrayList<Integer>(list));
            }
        }else{
            list.add(root.val);
            if(root.left == null && root.right == null){
                pathSum(root.left, sum, count + root.val, result, list);
                list.remove(list.size() - 1);
            }else if(root.left != null && root.right == null){
                pathSum(root.left, sum, count + root.val, result, list);
                list.remove(list.size() - 1);
            }else if(root.right != null && root.left == null){
                pathSum(root.right, sum, count + root.val, result, list);
                list.remove(list.size() - 1);
            }else{
                pathSum(root.left, sum, count + root.val, result, list);
                pathSum(root.right, sum, count + root.val, result, list);
                list.remove(list.size() - 1);
            }
        }
    }
}