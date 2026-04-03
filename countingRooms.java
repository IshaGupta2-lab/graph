import java.util.*;

public class countingRooms {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] grid = new char[n][m];

        for(int i = 0; i < n; i++){
            String row = sc.next();
            for(int j = 0; j < m; j++){
                grid[i][j] = row.charAt(j);
            }
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '.'){
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        System.out.println(count);
    }

    public static void bfs(char[][] grid, int i, int j){
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        grid[i][j] = '#';

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int d = 0; d < 4; d++){
                int ni = cur[0] + dx[d];
                int nj = cur[1] + dy[d];

                if(ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == '.'){
                    grid[ni][nj] = '#';
                    q.add(new int[]{ni, nj});
                }
            }
        }
    }
}