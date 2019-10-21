class Solution {
    public int maxPoints(int[][] points) {
        if(points == null || points.length == 0 || points[0] == null || points[0].length == 0) return 0;
        if(points.length <= 2) return points.length;
        int globalMax = 0;
        for(int i = 0; i < points.length - 1; i++){
            Map<String, Integer> map = new HashMap<>();  //use String to rep slope could make avoid the problem that caused by the precision of double
            int overlap = 0;
            int max = 0;
            for(int j = i + 1; j < points.length; j++){
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if( x == 0 && y == 0){
                    overlap++;
                    continue;
                }
                int gcd = gcd(x, y);  //get the great common divisor for x and y
                x = x / gcd;
                y = y / gcd;
                String slope = String.valueOf(x) + String.valueOf(y);  //store the slope
                int count = map.getOrDefault(slope, 0);  
                count++;
                map.put(slope, count);  //update the count
                max = Math.max(max, count);  //to get the max value with each fixed point
            }
            globalMax = Math.max(globalMax, max + overlap + 1);  //to get the max value from each fixed point
        }
        return globalMax;
    }
    private int gcd(int x, int y){
        if(y == 0) return x;
        return gcd(y, x % y);
    }
}
