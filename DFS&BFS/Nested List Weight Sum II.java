/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int sum = 0, levelSum = 0;
        Queue<NestedInteger> que = new LinkedList<>();
        for(NestedInteger ni : nestedList){
            que.offer(ni);
        }
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                NestedInteger cur = que.poll();
                if(cur.isInteger()) levelSum += cur.getInteger();
                else{
                    for(NestedInteger ni : cur.getList()){
                        que.offer(ni);
                    }
                }
            }
            sum += levelSum; //levelSum = layer1 + (layer1 + layer2) + (layer1 + layer2 + layer3)
        }
        return sum;
    }
}
