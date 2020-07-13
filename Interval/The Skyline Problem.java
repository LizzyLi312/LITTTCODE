class Solution {
     private class EndPoint implements Comparable<EndPoint>{
        public int height, val;
        public boolean isStart;
        
        public EndPoint(int height, int val, boolean isStart){
            this.height = height;
            this.val = val;
            this.isStart = isStart;
        }
        
        @Override
        public int comapreTo(EndPoint that){
            if(this.val != that.val) return this.val - that.val;
            else{
                if(this.isStart && that.isStart) return that.height - this.height;
                else if(!this.isStart && ! that.isStart) return this.height - that.height;
                else return this.isStart ? -1 : 1;
            }
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if(buildings == null || buildings.length == 0 || buildings[0] == null || buildings[0].length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<EndPoint> endPoints = new ArrayList<>();
        for(int[] b : buildings){
            endPoints.add(new EndPoint(b[2], b[0], true));
            endPoints.add(new EndPoint(b[2], b[1], false));
        }
        Collections.sort(endPoints);
        Queue<Integer> heap = new PriorityQueue<Integer>(buildings.length, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        for(EndPoint ep : endPoints){
            if(ep.isStart){
                if(heap.isEmpty() || ep.height > heap.peek()){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(ep.val, ep.height);
                    res.add(temp);
                }
                heap.offer(ep.height);
            }
            else{
                heap.remove(ep.height);
                if(heap.isEmpty() || ep.height > heap.peek()){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(ep.val, heap.isEmpty() ? 0 : ep.height);
                    res.add(temp);
                }
            }
        }
        return res;
    }
}
//maxheap: O(n^2) since remove and check all intervlas

class Solution {
    private class EndPoint implements Comparable<EndPoint>{
        public int x, height, index;
        public boolean isEnd;
        public EndPoint(int x, int height, boolean isEnd, int index){
            this.x = x;
            this.height = height;
            this.isEnd = isEnd;
            this.index = index;
        }
        @Override
        public int compareTo(EndPoint that){
            if(this.x != that.x) return this.x - that.x;
            else{
                if(!this.isEnd && !that.isEnd) return that.height - this.height;
                else if(this.isEnd && that.isEnd) return this.height - that.height;
                else return this.isEnd ? 1 : -1;
            }
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        if(buildings.length == 0 || buildings[0].length == 0) return res;
        List<EndPoint> endPoints = new ArrayList<>();
        List<EndPoint> startPoints = new ArrayList<>();
        for(int i = 0; i < buildings.length; i++){
            int[] b = buildings[i];
            endPoints.add(new EndPoint(b[0], b[2], false, i));
            endPoints.add(new EndPoint(b[1], b[2], true, i));
            startPoints.add(new EndPoint(b[0], b[2], false, i));
        }
        Collections.sort(endPoints);
        Comparator<Integer> comparator = (a, b) -> startPoints.get(a).height != startPoints.get(b).height ? Integer.compare(startPoints.get(b).height, startPoints.get(a).height) : a - b;
        TreeSet<Integer> heap = new TreeSet<>(comparator);
        //treeset: cannot duplicate. so use index
        for(EndPoint ep : endPoints){
            if(!ep.isEnd){
                if(heap.isEmpty() || ep.height > startPoints.get(heap.first()).height){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(ep.x);
                    temp.add(ep.height);
                    res.add(temp);
                }
                heap.add(ep.index);
            }
            else{
                heap.remove(ep.index);
                if(heap.isEmpty() || ep.height > startPoints.get(heap.first()).height){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(ep.x);
                    temp.add(heap.isEmpty() ? 0 : startPoints.get(heap.first()).height);
                    res.add(temp);
                } 
            }
        }
        return res;
    }
}
