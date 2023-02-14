import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 统计所有独立的图中，包含节点最多的那个一张图是有多少个节点组成
public class LargestComponent {
    public static void main(String[] args) {
        HashMap<Integer, Integer[]> graph = new HashMap<>();
        graph.put(0, new Integer[]{0, 1, 5});
        graph.put(1, new Integer[]{0});
        graph.put(5, new Integer[]{0, 8});
        graph.put(8, new Integer[]{0, 5});
        graph.put(2, new Integer[]{3, 4});
        graph.put(3, new Integer[]{2, 4});
        graph.put(4, new Integer[]{3, 2});

        List<Integer> visited = new ArrayList<>();
        int longest = 0;

        for (Map.Entry < Integer, Integer[] > entry : graph.entrySet()) {
            int size = explore(graph, entry.getKey(), visited);
            longest = Math.max(size, longest);
        }

        System.out.println(longest);
    }

    public static int explore(HashMap<Integer, Integer[]> graph, Integer current, List<Integer> visited) {
        if (visited.contains(current)) return 0;

        visited.add(current);

        int size = 1;

        Integer[] neighbors = graph.get(current);
        if (neighbors == null) return 0;
        for (Integer neighbor : neighbors) {
            size += explore(graph, neighbor, visited);
        }

        return size;
    }
}
