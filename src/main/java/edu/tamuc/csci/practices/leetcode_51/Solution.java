package edu.tamuc.csci.practices.leetcode_51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 */

public class Solution {
    /*
     * Solution (1) : Simply DFS
     * @param n: The number of queens
     * @return: All distinct solutions
     */
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> res = new ArrayList<>();
//
//        int[] pattern = new int[n];
//        dfs(res, pattern, 0);
//
//        return res;
//    }
//
//    /**
//     * pattern[i] = j put queen at (i, j) position, e.g. pattern[0] = 3 ==> ". . . Q"
//     *
//     * @param res
//     * @param pattern
//     * @param row
//     */
//    private void dfs(List<List<String>> res,
//                     int[] pattern,
//                     int row) {
//        if (row == pattern.length) {
//            List<String> sol = formatSolution(pattern);
//            res.add(sol);
//        }
//
//        for (int col = 0; col < pattern.length; col++) {
//            if (!isValid(row, col, pattern)) continue;
//
//            pattern[row] = col;
//            dfs(res, pattern, row + 1);
//            // pattern[row] = 0; // why don't need backtracking here? bc. isValid() only uses part of the pattern array
//        }
//    }
//
//    private boolean isValid(int i, int j, int[] p) {
//        for (int k = 0; k < i; k++) {// remember only up to row k has been placed
//            if (j == p[k]
//                    || i + j == k + p[k] // "/"
//                    || j - i == p[k] - k) // "\"
//                return false;
//        }
//
//        return true;
//    }

//    private List<String> formatSolution(int[] pattern) {
//        List<String> res = new ArrayList<>();
//        for (int p : pattern) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < pattern.length; i++) {
//                if (i != p) sb.append(".");
//                else sb.append("Q");
//            }
//
//            res.add(sb.toString());
//        }
//
//        return res;
//    }
//
//    /**
//     * Solution (2): Memoization (dfs + backtracking)
//     * @param n
//     * @return
//     */
//    public List<List<String>> solveNQueens(int n) {
//
//        List<List<String>> res = new ArrayList<>();
//
//        dfs(res, new int[n], new boolean[n], new boolean[2 * n], new boolean[2 * n], 0);
//        return res;
//    }
//
//    // colTaken[1] = ture; ==> filling row, col=1 is not available
//    private void dfs(List<List<String>> res,
//                     int[] pattern,
//                     boolean[] colTaken,
//                     boolean[] sumTaken,
//                     boolean[] diffTaken,
//                     int row) {
//        final int n = pattern.length;
//        if(row == n) {
//            List<String> sol = formatSolution(pattern);
//            res.add(sol);
//        }
//
//        for(int col = 0; col < n; col++) {
//            if (colTaken[col] || sumTaken[row + col] || diffTaken[row - col + n]) continue;
//
//            colTaken[col] = true;
//            sumTaken[row + col] = true;
//            diffTaken[row - col + n] = true;
//
//            //visit
//            pattern[row] = col;
//            dfs(res, pattern, colTaken, sumTaken, diffTaken, row + 1);
//
//            colTaken[col] = false; //"back" tracking
//            sumTaken[row + col] = false;
//            diffTaken[row - col + n] = false;
//        }
//    }

    //Solution(3) : Performance Tuning
    // ==> Reduce recursive call passed in variables
    // ==> Use Bit Manipulation
    private char[][] _board;
    private List<List<String>> res = new ArrayList<>();
    private long maxChoices;
    private int _n; // board size

    public List<List<String>> solveNQueens(int n) {
        if(n > 64) throw new IllegalArgumentException("Input too big for me...!");

        //init
        _n = n;
        maxChoices = n == 64 ? -1 : (1 << n) - 1; // 11111 ...11 (64 ==> -1) // 63
        _board = new char[n][n];
        for (char[] c : _board) Arrays.fill(c, '.');

        dfs(0, 0, 0, 0);
        return res;
    }

    //fill the board by rows
    void dfs(long colTaken, long propL, long propR, int row) {
        if (row == _n) {
            List<String> cur = new ArrayList<>();
            for (char[] c : _board) cur.add(new String(c));
            res.add(cur);
            return;
        }

        long avail = (~(colTaken | propL | propR)) & maxChoices; // 00011010100
        while (avail > 0) {
            long p = avail & -avail; //lsb => 0000...0100
            int k = 0;
            for (long i = p; i > 1; i >>>= 1) k++;

            _board[row][k] = 'Q';
            dfs(colTaken | p, (propL | p) << 1, (propR | p) >>> 1, row + 1);
            _board[row][k] = '.'; //back track

            avail -= p;
        }
    }
}
