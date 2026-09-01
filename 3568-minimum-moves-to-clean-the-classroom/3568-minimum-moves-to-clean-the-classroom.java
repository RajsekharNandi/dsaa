class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        int[][] lampIdx = new int[m][n];
        int sx = 0, sy = 0, cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    sx = i;
                    sy = j;
                } else if (c == 'L') {
                    lampIdx[i][j] = cnt;
                    cnt++;
                }
            }
        }

        if (cnt == 0) {
            return 0;
        }

        int fullMask = (1 << cnt) - 1;
        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << cnt];
        visited[sx][sy][energy][fullMask] = true;

        int[] dirs = {-1, 0, 1, 0, -1};

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy, energy, fullMask});
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] state = queue.poll();
                int i = state[0], j = state[1], e = state[2], mask = state[3];

                if (mask == 0) {
                    return moves;
                }
                if (e <= 0) {
                    continue;
                }

                for (int k = 0; k < 4; k++) {
                    int ni = i + dirs[k];
                    int nj = j + dirs[k + 1];

                    if (ni >= 0 && ni < m && nj >= 0 && nj < n
                            && classroom[ni].charAt(nj) != 'X') {
                        char cell = classroom[ni].charAt(nj);
                        int nEnergy = (cell == 'R') ? energy : e - 1;
                        int nMask = mask;

                        if (cell == 'L') {
                            nMask &= ~(1 << lampIdx[ni][nj]);
                        }

                        if (!visited[ni][nj][nEnergy][nMask]) {
                            visited[ni][nj][nEnergy][nMask] = true;
                            queue.add(new int[]{ni, nj, nEnergy, nMask});
                        }
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}