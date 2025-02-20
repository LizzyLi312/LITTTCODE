class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        
        int idx = 0; 
        while (idx < words.length) {
            int right = findLine(idx, words, maxWidth);
            res.add(justify(idx, right, words, maxWidth));
            idx = right + 1;
        }
        return res;
    }

    private int findLine(int idx, String[] words, int max) {
        int cnt = 0;
        int right = idx;
        for (int i = idx; i < words.length; i++) {
            cnt += words[i].length() + 1;
            if (cnt - 1 > max) return right - 1; // return right - 1 since right will be bigger than idx by 1 
            right++;
        }
        return right - 1;
    }

    private String justify(int st, int ed, String[] words, int max) {
        if (ed - st == 0) return padResult(words[st], max);

        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for (int i = st; i <= ed; i++) {
            cnt += words[i].length();
        }
        
        boolean lastLine = ed == words.length - 1 ? true : false;
        int totalSpace = max - cnt;
        int spaceCnt = ed - st;

        String space = lastLine ? " " : blank(totalSpace / spaceCnt);
        int remainder = lastLine ? 0 : totalSpace % spaceCnt;

        for (int i = st; i <= ed; i++) {
            sb.append(words[i])
                .append(space)
                .append(remainder-- > 0 ? " " : "");
        }
        return padResult(sb.toString().trim(), max); // remember to trim since last word would have extra spaces
    }

    private String padResult(String res, int max) {
        int blankCnt = max - res.length();
        StringBuilder sb = new StringBuilder();
        sb.append(res);
        sb.append(blank(blankCnt));
        return sb.toString();
    }

    private String blank(int a) {
        StringBuilder sb = new StringBuilder();
        while (a-- > 0) sb.append(' ');
        return sb.toString();
    }
}
