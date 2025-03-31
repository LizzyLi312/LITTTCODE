class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;

        int idx = 0;
        Stack<String> st = new Stack<>();
        while (idx < path.length()) {
            while (idx < path.length() && path.charAt(idx) == '/') idx++;
            int begin = idx;
            if (begin == path.length()) break;
            while (idx < path.length() && path.charAt(idx) != '/') idx++;
            String s = path.substring(begin, idx);
            if (s.equals("..")) {
                if (!st.isEmpty()) st.pop();
            } 
            else if (!s.equals(".")) st.push(s); 
        }

        String res = "";
        if (st.isEmpty) res = "/";
        
        while (!st.isEmpty()) {
            res = "/" + st.pop() + res;
        }
        return res;
    }
}
