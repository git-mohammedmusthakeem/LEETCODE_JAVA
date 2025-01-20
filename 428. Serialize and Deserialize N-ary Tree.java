class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    */
    class Codec {
        private static final String split = ",";
        private static final String start = "[";
        private static final String end = "]";
        private static final String NULL = "#";
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }
        private void serialize(Node node, StringBuilder sb){
            if(node == null){
                sb.append(NULL + split);
                return;
            }
            sb.append(node.val);
            if(node.children != null && node.children.size() > 0){
                sb.append(start);
                for(Node n : node.children){
                    serialize(n, sb);
                }
                sb.append(end);
            }
            sb.append(split);
        }
        private int index = 0;
        private char[] arr;
        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if(data.equals(NULL + split)) return null;
            this.arr = data.toCharArray();
            return deserialize().get(0);
        }
        private List<Node> deserialize(){
            Node node = null;
            List<Node> list = new ArrayList<>();
            while(index < arr.length){
                char c = arr[index];
                if(Character.isDigit(c)){
                    int num = 0;
                    while(index < arr.length && Character.isDigit(arr[index])){
                        num = num * 10 + arr[index++] - '0';
                    }
                    index--;
                    node = new Node(num, new ArrayList<>());
                    list.add(node);
                }else if(("" + c).equals(start)){
                    index++;
                    node.children = deserialize();
                }else if(("" + c).equals(end)){
                    index++;
                    return list;
                }
                index++;
            }
            return list;
        }
    }