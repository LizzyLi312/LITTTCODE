//time: O(n^2)
class Solution {
    public boolean rotateString(String A, String B) {
        if(A == null && B == null || (A.length() == 0 && B.length() == 0)) return true;
        if(A == null || B == null) return false;
        if(A.length() != B.length()) return false;
        char c = A.charAt(0);
        int i = 0;
        while(i < B.length()){
            while(i < B.length() && B.charAt(i) != c){ //find offset
                i++;
            }
            if(i == B.length()) return false; //if there is no beginning character of A in B then return false;
            for(int j = 0; j < B.length(); j++){
                if(A.charAt(j) != B.charAt((j + i) % B.length())) break; //circular array
                if(j == B.length() - 1) return true; //if it comes to the last one then it matches
            }
            i++;
        }
        return false;
    }
}

//find the substring in A+A
class Solution {
    public boolean rotateString(String A, String B) {
        if(A == null && B == null ) return true;
        if(A == null || B == null ) return false;
        
        return A.length() == B.length() && (A + A).contains(B);
    }
}
