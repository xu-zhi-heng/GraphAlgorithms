import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 统计有多少张独立的图: 意思就是不相连，单独存在的图
public class ConnectedComponentsCount {
    public static void main(String[] args) {
        HashMap<Integer, Integer[]> graph = new HashMap<>();
        graph.put(0, new Integer[]{8, 1, 5});
        graph.put(1, new Integer[]{0});
        graph.put(5, new Integer[]{0, 8});
        graph.put(8, new Integer[]{0, 5});
        graph.put(2, new Integer[]{3, 4});
        graph.put(3, new Integer[]{2, 4});
        graph.put(4, new Integer[]{3, 2});

        int count = 0;
        List<Integer> visited = new ArrayList<>();

        for (Map.Entry < Integer, Integer[] > entry : graph.entrySet()) {
            if (explore(graph, entry.getKey(), visited)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean explore(HashMap<Integer, Integer[]> graph, Integer current, List<Integer> visited) {
        if (visited.contains(current)) return false;

        visited.add(current);

        Integer[] neighbors = graph.get(current);
        if (neighbors == null) return false;
        for (Integer neighbor : neighbors) {
            explore(graph, neighbor, visited);
        }

        return true;
    }
}
