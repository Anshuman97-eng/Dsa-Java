import java.util.*;

class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[n][m];

        // Step 1: directions (4 moves only)
        int[][] dirs = {
                { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
        };

        // Step 2: loop through grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++; // ✅ new island found
                    // 👉 You will write BFS/DFS here
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] { i, j });
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        int[] pol = q.poll();
                        int r = pol[0];
                        int c = pol[1];

                        for (int[] dir : dirs) {
                            int row = r + dir[0];
                            int col = c + dir[1];

                            if (row >= 0 && col >= 0 && row < n && col < m &&
                                    grid[row][col] == '1' && !visited[row][col]) {
                                visited[row][col] = true;
                                q.add(new int[] { row, col });
                            }

                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0' },
                { '0', '1', '0' },
                { '0', '0', '1' }
        };
        System.out.println(numIslands(grid)); // Expected: 2
    }
}
