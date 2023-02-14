import java.util.ArrayList;
import java.util.List;

/**
 * 统计一张图中有多少个陆地
 */
public class isLandCount {
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

        int count = 0;
        for (int i = 0; i < gird.length; i++) {
            for (int j = 0; j < gird[0].length; j++) {
                if (explore(gird, i, j, visited)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean explore(String[][] grid, int x, int y, List<String> visited) {
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1) {
            return false;
        }
        if (grid[x][y].equals("w")) {
            return false;
        }

        if (visited.contains(x + "," + y)) {
            return false;
        }

        visited.add(x + "," + y);

        explore(grid, x - 1, y, visited);
        explore(grid, x + 1, y, visited);
        explore(grid, x, y + 1, visited);
        explore(grid, x, y - 1, visited);

        return true;
    }
}
