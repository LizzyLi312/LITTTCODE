class MedianFinder {
    PriorityQueue<Integer> minHeap, maxHeap; 

    public MedianFinder() {
        minHeap = new PriorityQueue<>(); // descreasing order for high nums
        maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1)); //increasing order for low nums
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll()); // need to go through the whole queue
        if (minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll()); // keep the median in maxHeap smaller side 
    }
    
    public double findMedian() {
        double res;
        if (maxHeap.size() == minHeap.size()) res = ((double)maxHeap.peek() + (double)minHeap.peek()) / 2;
        else res = (double)maxHeap.peek();
        return res;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
