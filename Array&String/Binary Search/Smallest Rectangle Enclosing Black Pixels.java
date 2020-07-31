class Solution {
    public int minArea(char[][] image, int x, int y) {
        if(image == null || image[0] == null) return 0;
        int upper = 0, lower = image.length - 1, left = 0, right = image[0].length - 1;
        //upper boundery
        int start = upper, end = x;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(allZero(image, mid, true)) start = mid + 1;
            else end = mid - 1;
        }
        upper = start; //pay attention to the boundery 
        
        start = x;
        end = lower;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(allZero(image, mid, true)) end = mid - 1;
            else start = mid + 1;
        }
        lower = end;
        
        start = 0;
        end = y;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(allZero(image, mid, false)) start = mid + 1;
            else end = mid - 1;
        }
        left = start;
        
        start = y;
        end = right;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(allZero(image, mid, false)) end = mid - 1;
            else start = mid + 1;
        }
        right = end;
        
        return (right - left + 1) * (lower - upper + 1);
    }
    private boolean allZero(char[][] image, int mid, boolean isRow){
        if(isRow){
            for(int i = 0; i < image[0].length; i++){
                if(image[mid][i] == '1') return false;
            }
            return true;
        }
        else{
            for(int i = 0; i < image.length; i++){
                if(image[i][mid] == '1') return false;
            }
            return true;
        }
    }
}
