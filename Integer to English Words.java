//e.g. 1,274,378 use recursion to solve the problem. And seperate them into different chunks. each chunk has 3 integers.
//helper is to recur each chunk from the ones to hundreds
class Solution {
    private final String[] UNDER20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int i = 0;
        String words = "";
        while(num > 0){
            if(num % 1000 != 0) words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            num /= 1000;
            i++;
        }
        return words.trim();  //It returns the omitted string with no leading and trailing spaces
    }
    private String helper(int num){
        if(num == 0) return "";
        else if(num < 20) return UNDER20[num] + " "; //
        else if(num < 100) return TENS[num / 10] + " " + helper(num % 10);
        else return UNDER20[num / 100] + " Hundred " + helper(num % 100);
    }
}
