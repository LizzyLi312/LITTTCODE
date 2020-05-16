class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>(){  //quick sort
            @Override
            public int compare(String i, String j){
                String s1 = i + j;
                String s2 = j + i; 
                return s2.compareTo(s1); //decreasing order
            }
        });
        
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < strs.length; i++){
            res.append(strs[i]);
        }
        if(res.length() == 0 || res.charAt(0) == '0') return "0"; //check if the highest digit 
        return res.toString();
    }
}
