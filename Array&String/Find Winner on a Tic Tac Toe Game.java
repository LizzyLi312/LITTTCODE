class Solution {
    public String tictactoe(int[][] moves) {
        if (moves == null || moves.length == 0 || moves[0] == null || moves[0].length == 0) return "Draw";
        int[] cntA = new int[8]; // 3 rows, 3 cols, 2dia
        int[] cntB  = new int[8];

        for (int i = 0; i < moves.length; i++) {
            int r = moves[i][0], c = moves[i][1];
            if (i % 2 == 0) {
                cntA[r]++;
                cntA[c + 3]++;
                if (r == c) cntA[6]++;
                if (r + c == 2) cntA[7]++;
            } else {
                cntB[r]++;
                cntB[c + 3]++;
                if (r == c) cntB[6]++;
                if (r + c == 2) cntB[7]++;
            }
        }

        for (int i = 0; i < 8; i++) {
            if (cntA[i] == 3) return "A";
            if (cntB[i] == 3) return "B";
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }
}
