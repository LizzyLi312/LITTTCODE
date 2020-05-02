//reverse the whole string then reverse each word
class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        String str = s.trim(); //cut the tailing and heading spaces
        String rever = reverse(str); //reverse the whole sentence
        String words = reverseWord(rever); //reverse each word
        return clean(words.toCharArray());
    }
    private String clean(char[] s){ //use 2 pointers. inplace remove extra space 
        int slow = 0, n = s.length;
        for(int fast = 0; fast < n; fast++){
            if(s[fast] == ' ' && s[fast - 1] != ' ') s[slow++] = s[fast];
            else if(s[fast] != ' ') s[slow++] = s[fast];
            else continue;
        }
        // if(s[slow - 1] == ' ') return new String(s).substring(0, slow - 1);
        return new String(s).substring(0, slow);
    }
    private String reverse(String s){
        if(s.length() == 0) return "";
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while(left < right){
            swap(arr, left++, right--);
        }
        return new String(arr);
    }
    private String reverseWord(String s){
        if(s.length() == 0) return "";
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == ' ') continue;
            else if(arr[i] != ' '){ //find the start & end for each word
                int j = i + 1;
                while(j < arr.length && arr[j] != ' '){
                    j++;
                }
                int left = i, right = j - 1;
                while(left < right){ //reverse each word
                    swap(arr, left++, right--);
                }
                i = j; //move to the next search
            }
        }
        return new String(arr);
    }
    private void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

//using split and trim. cannot handle when there is multiple spaces between 2 characters
class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        String[] tokens = s.split(" ");
        int left = 0, right = tokens.length - 1;
        while(left < right){
            String temp = tokens[left];
            tokens[left] = tokens[right];
            tokens[right] = temp;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for(String token : tokens){
            sb.append(token + " ");
        }
        String res = sb.toString();
        return res.trim();
    }
}
