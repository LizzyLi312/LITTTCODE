// binary search: find the dis of each house to the heater to right and left, and then get the max dis along the way 
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int res = 0;
        Arrays.sort(heaters); // nlogn : heaters' length is n

        for (int house : houses) { mlogn 
            int left = leftHeater(house, heaters);
            int right = rightHeater(house, heaters);

            int dis1 = left == -1 ? Integer.MAX_VALUE : house - heaters[left];
            int dis2 = right == -1 ? Integer.MAX_VALUE : heaters[right] - house;

            res = Math.max(res, Math.min(dis1, dis2));
        }

        return res;
    }

    private int leftHeater(int target, int[] heaters) { // t: 5, h:[2,3,6,7]
        int l = 0, r = heaters.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (target >= heaters[mid]) l = mid;
            else r = mid - 1;
        }
        return heaters[l] <= target ? l : -1;
    }

    private int rightHeater(int target, int[] heaters) {
        int l = 0, r = heaters.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target <= heaters[mid]) r = mid;
            else l = mid + 1;
        }
        return heaters[l] >= target ? l : -1;
    }

}
