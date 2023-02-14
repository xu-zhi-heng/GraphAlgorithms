import java.util.ArrayList;
import java.util.List;

// 求最小岛的大小
public class MinimumIsland {
    static List<String> visited = new ArrayList<>();
    public static void main(String[] args) {
        String[][] gird = new String[][]{
                {"w", "l", "w", "w", "w"},
                {"w", "l", "w", "w", "w"},
                {"w", "w", "w", "l", "w"},
                {"w", "w", "l", "l", "w"},
                {"l", "w", "w", "l", "l"},
                {"l", "l", "w", "w", "w"},
        };

        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i < gird.length; i++) {
            for (int j = 0; j < gird[0].length; j++) {
                int size = exploreSize(gird, i, j, visited);
                if (size > 0) {
                    minSize = Math.min(size, minSize);
                }
            }
        }
        System.out.println(minSize);
    }
    
    public static int exploreSize(String[][] grid, int x, int y, List<String> visited) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1) {
            return 0;
        }
        if (grid[x][y].equals("w")) {
            return 0;
        }

        if (visited.contains(x + "," + y)) {
            return 0;
        }

        visited.add(x + "," + y);

        int size = 1;
        size += exploreSize(grid, x - 1, y, visited);
        size += exploreSize(grid, x + 1, y, visited);
        size += exploreSize(grid, x, y + 1, visited);
        size += exploreSize(grid, x, y - 1, visited);

        return size;
    }
}
