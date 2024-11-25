class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return createTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    private TreeNode createTree(int[] inOrder, int iStart, int iEnd, int[] postOrder, int pStart, int pEnd, Map<Integer, Integer> map){
        if(iStart > iEnd || pStart > pEnd) return null;
        TreeNode node = new TreeNode(postOrder[pEnd]);
        int index = map.get(postOrder[pEnd]);
        int len = iEnd - index;
        node.left = createTree(inOrder, iStart, index - 1, postOrder, pStart, pEnd - len - 1, map);
        node.right = createTree(inOrder, index + 1, iEnd, postOrder, pEnd - len, pEnd - 1, map);
        return node;
    }
}