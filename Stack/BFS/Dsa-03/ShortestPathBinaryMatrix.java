import java.util.*;

class ShortestPathBinaryMatrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Step 1: check start/end
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        // Step 2: setup BFS queue
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1}); // row, col, distance
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        // Step 3: directions (8 moves)
        int[][] dirs = {
            {1,0}, {-1,0}, {0,1}, {0,-1},
            {1,1}, {1,-1}, {-1,1}, {-1,-1}
        };

        // 👉 You will write the BFS loop here
        while (!q.isEmpty()) {
            int[] get = q.poll();
            int r = get[0];
            int c = get[1];
            int dist = get[2];

            if(r == n-1 && c == n-1){
                return dist;
            }

            for(int[] dir : dirs){
                int row = r + dir[0];
                int col = c + dir[1];

                if(row >= 0 && col >= 0 && row < n && col < n && grid[row][col] == 0 && !visited[row][col]){
                    visited[row][col] = true;
                    q.add(new int[]{row,col,dist+1});
                }
            }
        }


        return -1; // if not reachable
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0,1,0},
            {0,0,0},
            {1,0,0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
