//Topological Sort using DFS
class Solution {
    private enum Status{ //status 
        INITIAL, VISITING, VISITED;
    }
    private static class V{
        public int label;
        public List<Integer> nexts;
        public Status status;
        public V(int label){
            this.label = label;
            this.nexts = new ArrayList<Integer>();
            status = Status.INITIAL;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        V[] arr = new V[numCourses];
        for(int i = 0; i < numCourses; i++){ //build graph
            arr[i] = new V(i);
        }
        int row = prerequisites.length;
        for(int i = 0; i < row; i++){ //put infor into each vertices
            int prev = prerequisites[i][1], next = prerequisites[i][0];
            arr[prev].nexts.add(next);
        }
        for(int i = 0; i < numCourses; i++){
            if(isCycled(arr[i], arr)) return false; //check cycled 
        }
        return true;
    }
    private boolean isCycled(V source, V[] arr){ 
        if(source.status == Status.VISITED) return false;  //pruning
        if(source.status == Status.VISITING) return true;  
        source.status = Status.VISITING;
        for(int i : source.nexts){
            if(isCycled(arr[i], arr)) return true;
        }
        source.status = Status.VISITED;
        return false;
    }
}
