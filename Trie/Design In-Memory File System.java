//implement hashmap to make trie
class FileSystem {
    class File{
        boolean isFile;
        Map<String, File> children;
        String content;
        public File(){
            isFile = false;
            children = new HashMap<>();
            content = "";
        }
    }
    File root = null;
    public FileSystem() {
        root = new File();
    }
    
    public List<String> ls(String path) {
        String[] dirs = path.split("/");
        File node = root;
        List<String> res = new ArrayList<>();
        String name = "";
        for(String dir : dirs){
            if(dir.length() == 0) continue;
            if(!node.children.containsKey(dir)) return res;
            node = node.children.get(dir);
            name = dir; //need to remember the name, node is the file. that's different 
        }
        if(node.isFile) res.add(name);
        else{
            for(String key : node.children.keySet()){
                res.add(key);
            }
        }
        Collections.sort(res);
        return res;
    }
    
    public void mkdir(String path) {
        String[] dirs = path.split("/");
        File node = root;
        for(String dir : dirs){
            if(dir.length() == 0) continue; //the last space is a coner case. e.g. "/a/b/c/"
            if(!node.children.containsKey(dir)){
                File file = new File();
                node.children.put(dir, file);
            }
            node = node.children.get(dir);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] dirs = filePath.split("/");
        File node = root;
        for(String dir : dirs){
            if(dir.length() == 0) continue; //cc
            if(!node.children.containsKey(dir)){
                File file = new File();
                node.children.put(dir, file);
            }
            node = node.children.get(dir);
        }
        node.isFile = true;
        node.content = node.content + content;
    }
    
    public String readContentFromFile(String filePath) {
        String[] dirs = filePath.split("/");
        File node = root;
        for(String dir : dirs){
            if(dir.length() == 0) continue;
            if(!node.children.containsKey(dir)){
                File file = new File();
                node.children.put(dir, file);
            }
            node = node.children.get(dir);
        }
        return node.content;
    }
}
