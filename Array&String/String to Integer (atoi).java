class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        int res = 0;
        int sign = 1;
        int i = 0;
        while(i < str.length() && str.charAt(i) == ' '){
            i++;
        }
        if(i == str.length()) return 0;
        if(str.charAt(i) == '-'){
            sign = -1;
            i++;
        }
        else if(str.charAt(i) == '+'){
            sign = 1;
            i++;
        }
        else if(!Character.isDigit(str.charAt(i))) return 0;
        for(int j = i; j < str.length(); j++){
            if(!Character.isDigit(str.charAt(j))) break; //put this check at the beginning 
            if(res > Integer.MAX_VALUE / 10 || (Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < str.charAt(j) - '0')){
            //prevent integer overflow using integer.max_value / 10 
            //
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            res = res * 10 + str.charAt(j) - '0';
        }
        return res * sign;
    }
}
