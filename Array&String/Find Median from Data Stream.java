//The invariant of the algorithm is two heaps, small and large, each represent half of the current list. The length of smaller half is kept to be n / 2 at all time and the length of the larger half is either n / 2 or n / 2 + 1 depend on n's parity.
/*
Any time before we add a new number, there are two scenarios, (total n numbers, k = n / 2):
(1) length of (small, large) == (k, k)
(2) length of (small, large) == (k, k + 1)
After adding the number, total (n + 1) numbers, they will become:
(1) length of (small, large) == (k, k + 1)
(2) length of (small, large) == (k + 1, k + 1)
*/
class MedianFinder {
    private Queue<Integer> maxHeap; //size: n / 2 or n - n /2
    private Queue<Integer> minHeap; //size: n/2 
    private boolean even = true;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer num1, Integer num2){
                return num2 - num1;
            }
        });
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(even){
            maxHeap.offer(num); //if the new number if bigger than all the numbers in maxHeap it would be heapify to the top and get popped into the minHeap
            minHeap.offer(maxHeap.poll());
        }
        else{
            minHeap.offer(num); //if the new number if smaller than all the numbers..
            maxHeap.offer(minHeap.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even) return (minHeap.peek() + maxHeap.peek()) / 2.0;
        else return minHeap.peek();
    }
}

/*
Alltogether, the add operation is O(logn), The findMedian operation is O(1).
follow up will be: what if the input is too big? put into the hard disk. but we need to store each element 
 */
