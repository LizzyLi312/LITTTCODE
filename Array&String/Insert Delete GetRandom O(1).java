//2 data structure 
class RandomizedSet {
    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> nums;
    private java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) { //HashMap O(1)
        boolean contain = map.containsKey(val);
        if(contain) return false;
        map.put(val, nums.size()); //val and index
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) { 
        //switch the element with the last element so we can make delete O(1)
        boolean contain = map.containsKey(val);
        if(!contain) return false;
        int loc = map.get(val);
        if(loc < nums.size() - 1){
            int lastOne = nums.get(nums.size() - 1);
            nums.set(loc, lastOne); //use last element's value to replace the value
            map.put(lastOne, loc);
        }
        map.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
