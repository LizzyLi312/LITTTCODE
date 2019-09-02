/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            if(res == 0) return mid;
            if(res == 1)
                left = mid + 1;  //here is the tricky part! 
            else right = mid - 1;
        }
        return -1;
    }
}

//using the other plate of BS. The condition of while loop is different. At the tricky part, you should remember to -1 and +1 to assign the value of left or right. Cause there's a corner casue will crush your code if you do not do that
