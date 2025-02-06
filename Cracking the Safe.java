// To make the input password as short as possible, we'd better make each possible length-n combination on digits [0..k-1] occurs exactly once as a substring of the password. The existence of such a password is proved by De Bruijn sequence: 
class Solution {
    int combSize;
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('0'); //starting point: n 0s
        }

        combSize = (int) Math.pow(k, n); // In order to guarantee to open the box at last, the input password ought to contain all length-n combinations on digits [0..k-1] - there should be k^n combinations in total. 
        // note: Math.pow return a value of double
        HashSet<String> visited = new HashSet<>();
        visited.add(sb.toString());
        
        dfs(sb, n, k, visited);
        return sb.toString();
    }

    private boolean dfs(StringBuilder pwd, int n, int k, HashSet<String> visited) {
        if (visited.size() == combSize) return true;

        String sub = pwd.substring(pwd.length() - n + 1); // if the last n - 1 digits of node1 can be transformed to node2 by appending a digit from 0..k-1, there will be an edge between node1 and node2
        for (char c = '0'; c < '0' + k; c++) {
            String newPwd = sub + c;
            if (!visited.contains(newPwd)) {
                visited.add(newPwd);
                pwd.append(c);
                if (dfs(pwd, n, k, visited)) return true;
                pwd.setLength(pwd.length() - 1); //back tracing
                visited.remove(newPwd);
            }
        }
        return false;
    }
}

// StringBuilder: substring(int start) - Returns a new String that contains a subsequence of characters currently contained in this character sequence.
