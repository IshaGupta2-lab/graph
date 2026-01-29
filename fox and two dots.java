import java.util.*;

public class Main {

    static int n, m;
    static char[][] grid;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            grid[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1)) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }

        System.out.println("No");
    }

    public static boolean dfs(int x, int y, int px, int py) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (grid[nx][ny] != grid[x][y]) continue;

            if (!visited[nx][ny]) {
                if (dfs(nx, ny, x, y)) return true;
            } 
            else if (nx != px || ny != py) {
        
                return true;
            }
        }
        return false;
    }
}
