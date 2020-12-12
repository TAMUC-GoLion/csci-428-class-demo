package edu.tamuc.csci.practices.leetcode_547;

/**
 * Demo of applying BFS/DFS in graph search
 */

class Solution {
    //(2) DFS
    public int findCircleNum(int[][] M) {
        if(M == null || M[0] == null) return -1;

        int cnt = 0;
        for(int i = 0; i < M.length; i++) {
            if(M[i][i] != 1) continue;

            cnt++;
            dfs(M, i);
        }
        return cnt;
    }

    private void dfs(int[][] M, int i) {
        M[i][i] = 0;
        for(int j = 0; j < M[0].length; j++) {
            if(M[i][j] != 1 || M[j][j] != 1) continue;

//            M[i][j] = 0;
//            M[j][i] = 0;
            dfs(M, j);
        }
    }

    // BFS (improved)
//     public int findCircleNum(int[][] M) {
//         if(M == null || M[0] == null) return -1;

//         final int n = M.length;
//         int numCircle = 0;

//         int[] que = new int[1 << 8];
//         for(int c = 0; c < n; c++) {
//             if(M[c][c] != 1) continue;

//             numCircle++;
//             int size = 0, cur = 0;
//             que[size++] = c;
//             while(cur < size) {
//                 int p = que[cur++];
//                 for(int i = 0; i < n; i++) {
//                     if(M[p][i] != 1 || M[i][i] != 1) continue;
//                     que[size++] = i;
//                     M[i][i] |= Integer.MIN_VALUE; //note here!
//                 }
//             }
//         }

//         return numCircle;
//     }

    //(1) BFS basic
//    public int findCircleNum(int[][] M) {
//        if(M == null || M[0] == null) return -1;
//
//        final int n = M.length;
//        int numCircle = 0;
//
//        Queue<Integer> que = new ArrayDeque<>();
//        for(int c = 0; c < n; c++) {
//            if(M[c][c] != 1) continue;
//
//            numCircle++;
//            que.offer(c);
//            while(!que.isEmpty()) {
//                int cur = que.poll();
//
//                for(int i = 0; i < n; i++) {
//                    if(M[cur][i] != 1 || M[i][i] != 1) continue;
//                    que.offer(i);
//                    M[i][i] |= Integer.MIN_VALUE;
//                }
//            }
//        }
//
//        return numCircle;
//    }
}
