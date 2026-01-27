
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] result = new int[n][m];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, 0, 0 });
        result[0][0] = 0;

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int effort = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (effort > result[row][col])
                continue;

            if (row == n - 1 && col == m - 1) {
                return effort;
            }

            for (int k = 0; k < 4; k++) {
                int nx = row + dirs[k][0];
                int ny = col + dirs[k][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int diff = Math.abs(heights[row][col] - heights[nx][ny]);
                    int newEffort = Math.max(effort, diff);

                    if (result[nx][ny] > newEffort) {
                        result[nx][ny] = newEffort;
                        pq.add(new int[] { newEffort, nx, ny });
                    }
                }
            }
        }
        return 0;
    }
}
