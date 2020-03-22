//You are playing the following Flip Game with your friend: Given a string that contains only these two characters:
// + and -, you and your friend take turns to flip two consecutive "++" into "--".
// The game ends when a person can no longer make a move and therefore the other person will be the winner.
//Write a function to determine if the starting player can guarantee a win.
//For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".
public class FlipGame2 {
    public static boolean canWin(String s) {
        if (s == null || s.length() == 0) return false;
        return dfs(s.toCharArray());
    }

    private static boolean dfs(char[] s) {
        for (int i = 0; i + 1 < s.length; i++) {
            if (s[i] == '+' && s[i + 1] == '+') {
                s[i] = '-';
                s[i + 1] = '-';
                boolean res = dfs(s); //cache before backtrace. since if return the value here. it never got set back to '+'
                s[i] = '+';
                s[i + 1] = '+';
                if(!res) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canWin("+++++"));
    }
}
//with pruning 
    private static boolean dfs(char[] s, HashMap<String, Boolean> map) {
        String temp = new String(s);
        if(map.containsKey(temp)) return map.get(temp);
        for (int i = 0; i + 1 < s.length; i++) {
            if (s[i] == '+' && s[i + 1] == '+') {
                s[i] = '-';
                s[i + 1] = '-';
                boolean res = dfs(s, map);
                s[i] = '+';
                s[i + 1] = '+';
                if(!res){
                    map.put(new String(temp), true);
                    return true;
                }
            }
        }
        map.put(new String(temp), false);
        return false;
    }

