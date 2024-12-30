public class Codec {
    private final String split = ",";
    private final String empty = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    private void serialize(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append(empty).append(split);
        }else{
            sb.append(node.val).append(split);
            serialize(node.left, sb);
            serialize(node.right, sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(split);
        LinkedList<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(nodes));
        return deserialize(q);
    }
    private TreeNode deserialize(LinkedList<String> q){
        String val = q.poll();
        if(val.equals(empty)){
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = deserialize(q);
            node.right = deserialize(q);
            return node;
        }
    }
}