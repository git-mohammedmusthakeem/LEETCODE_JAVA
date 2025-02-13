class FileSystem {
        private static final class File{
            boolean isFile;
            TreeMap<String, File> childs;   //key is the name, value is the file object.
            String name;
            String content;
            public File(String name){
                this.name = name;
                this.childs = new TreeMap<>();
            }
        }
        private File root;
        public FileSystem() {
            this.root = new File("/");
        }
        
        public List<String> ls(String path) {
            String[] tokens = path.split("/");
            File cur = root;
            for(int i = 1; i < tokens.length; i++){
                cur = cur.childs.get(tokens[i]);
            }
            List<String> result = new ArrayList<>();
            if(cur.isFile){
                result.add(cur.name);
            }else{
                for(String key : cur.childs.keySet()){
                    result.add(key);
                }
            }
            return result;
        }
        private File createFileOrDirectory(String path){
            File cur = root;
            String[] tokens = path.split("/");
            for(int i = 1; i < tokens.length; i++){
                if(!cur.childs.containsKey(tokens[i])){
                    File next = new File(tokens[i]);
                    cur.childs.put(tokens[i], next);
                }
                cur = cur.childs.get(tokens[i]);
            }
            return cur;
        }
        public void mkdir(String path) {
            createFileOrDirectory(path);
        }
        
        public void addContentToFile(String filePath, String content) {
            int index = filePath.lastIndexOf("/");
            File dir = createFileOrDirectory(filePath.substring(0, index));
            String filename = filePath.substring(index + 1);
            File file = null;
            if(!dir.childs.containsKey(filename)){
                file = new File(filename);
                dir.childs.put(filename, file);
                file.isFile = true;
                file.content = content;
            }else{
                file = dir.childs.get(filename);
                file.content += content;
            }
        }
        
        public String readContentFromFile(String filePath) {
            File file = createFileOrDirectory(filePath);
            return file.content;
        }
    }