class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums == null || k <= 0 || nums.length < k) return null;
        int len = nums.length;
        double[] res = new double[len - k + 1];
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> right = new TreeSet<>(comparator);
        Callable<Double> getMedian = () -> {
            while(left.size() > right.size()) right.add(left.pollFirst());
            return (k % 2 == 0) ? (double) nums[left.first()] + (double) nums[right.first()] / 2.0 : (double) nums[right.first()];
        };
        for(int i = 0; i < len; i++){
            if(i >= k){
                if(!left.remove(i - k)) right.remove(i - k);
            }
            right.add(i);
            left.add(right.pollFirst());
            if(i >= k - 1){
                try{
                    res[i - k + 1] = getMedian.call();
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }
}
