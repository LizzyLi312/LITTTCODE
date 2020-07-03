//while we comparing to the value we also need to record each value of these 2 arrays. So we use a wrapper
//You are given two integer arrays nums1 and nums2 sorted in ascending order means the smaller sum appear at the beginning of the arrays
//2 pointers and heap. we always will process the smallest one since heap
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return res;
        HashSet<Cell> set = new HashSet<>();
        PriorityQueue<Cell> heap = new PriorityQueue<>(new Comparator<Cell>(){
            @Override
            public int compare(Cell sum1, Cell sum2){
                return sum1.val - sum2.val;
            }
        });
        Cell c = new Cell(nums1[0] + nums2[0], 0, 0);
        heap.offer(c);
        set.add(c);
        while(k-- > 0){
            if(heap.isEmpty()) break;
            Cell cur = heap.poll();
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[cur.i]);
            temp.add(nums2[cur.j]);
            res.add(temp);
            int i = cur.i, j = cur.j;
            if(i + 1 < nums1.length){
                Cell c1 = new Cell(nums1[i + 1] + nums2[j], i + 1, j);
                if(!set.contains(c1)){
                    heap.offer(c1);
                    set.add(c1);
                }
            }
            if(j + 1 < nums2.length){
                Cell c2 = new Cell(nums1[i] + nums2[j + 1], i, j + 1);
                if(!set.contains(c2)){
                    heap.offer(c2);
                    set.add(c2);
                }
            }
        }
        return res;
    }
    class Cell{
        int val, i, j;
        public Cell(int val, int i, int j){
            this.val = val;
            this.i = i;
            this.j = j;
        }
        @Override
        public int hashCode(){
            return this.i * 31 + this.j;
        }
        @Override
        public boolean equals(Object o){
            if(o instanceof Cell){
                Cell c = (Cell) o;
                return this.i == c.i && this.j == c.j;
            }
            else return false;
        }
    }
}
