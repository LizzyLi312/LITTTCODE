//substract number from larger number to small number
class Solution {
    public String intToRoman(int num) {
        if(num < 1 && num > 3999) return null;
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD","C", "XC","L","XL","X","IX","V", "IV","I"}; //number with 4 are speical numbers too
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < vals.length; i++){
            while(num >= vals[i]){
                num -= vals[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }
}
//300: CCC
