class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length == 0) return res; 
        int idx = findIdx(arr, x);
        res.add(arr[idx]); //add the closest element first
        addRest(res, arr, idx, k - 1, x);
        return res;
    }
    private int findIdx(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) left = mid;
            else right = mid;
        }
        return Math.abs(arr[left] - target) < Math.abs(arr[right] - target) ? left : right;
    }
    private void addRest(List<Integer> res, int[] arr, int idx, int k, int target){
        if(k == 0) return;
        int left = idx - 1, right = idx + 1;
        while(left >= 0 && right < arr.length && k > 0){
            if(Math.abs(arr[left] - target) <= arr[right] - target) res.add(0, arr[left--]);
            else res.add(arr[right++]);
            k--;
        }
        while(k > 0){
            if(right < arr.length) res.add(arr[right++]);
            if(left > 0) res.add(0,arr[left--]);
            k--;
        }
    }
}
