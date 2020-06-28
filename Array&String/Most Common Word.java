class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph == null || paragraph.length() == 0) return "";
        HashSet<String> ban = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        String res = "";
        for(String ba : banned){
            ban.add(ba);
        }
        paragraph += "."; //corner case: paragraph: "Bob"
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < paragraph.length(); i++){
            if(Character.isLetter(paragraph.charAt(i))) temp.append(Character.toLowerCase(paragraph.charAt(i)));
            else if(temp.length() > 0){
                String re = temp.toString();
                if(map.containsKey(re)) map.put(re, map.get(re) + 1);
                else map.put(re, 1);
                if(max < map.get(re) && !ban.contains(re)){
                    max = map.get(re);
                    res = re;
                }
                temp.setLength(0);
            }
        }
        return res;
    }
}
