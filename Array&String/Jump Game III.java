class Solution {
    private Set<Integer> visited = new HashSet<>();
    public boolean canReach(int[] arr, int start) {
        if(arr == null || arr.length == 0) return false;
        if(start < 0 || start >= arr.length) return false;
        if(arr[start] == 0) return true;
        if(visited.add(start)){
            return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
        }
        else return false;
    }
}
//queue works too 
