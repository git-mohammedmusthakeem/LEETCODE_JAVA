class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return createTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    private TreeNode createTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> map){
        if(pStart > pEnd || iStart > iEnd) return null;
        TreeNode node = new TreeNode(preorder[pStart]);
        int index = map.get(preorder[pStart]);
        int len = index - iStart;
        node.left = createTree(preorder, pStart + 1, pStart + len, inorder, iStart, index - 1, map);
        node.right = createTree(preorder, pStart + len + 1, pEnd, inorder, index + 1, iEnd, map);
        return node;
    }
}