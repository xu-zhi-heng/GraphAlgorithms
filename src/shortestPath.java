import java.net.Inet4Address;
import java.util.*;

// 最短路径
public class shortestPath {
    public static void main(String[] args) {
        String[][] edges = new String[][]{
                {"w", "x"},
                {"x", "y"},
                {"z", "y"},
                {"z", "v"},
                {"w", "v"}
        };

        HashMap<String, List<String>> graph = buildGraph(edges);

        System.out.println(shortestPathBFS(graph, "w", "x"));
    }

    public static int shortestPathBFS(HashMap<String, List<String>> graph, String src, String dst) {
        LinkedList<TreeMap<String, Integer>> queen = new LinkedList<>();
        List<String> visited = new ArrayList<>();

        if (src.equals(dst)) {
            return 0;
        }

        visited.add(src);
        TreeMap<String, Integer> path = new TreeMap<>();
        path.put(src, 0);
        queen.push(path);

        while (!queen.isEmpty()) {
            // 从队列中取出第一个元素， 然后判断该节点和目标节点是否相等，如果相等，则返回长度
            TreeMap<String, Integer> current = queen.pollLast();
            String node = current.firstKey();
            if (node.equals(dst)) {
                return current.get(node);
            }
            // 当前节点距离出发点的距离值
            int distance = current.get(node);

            List<String> neighbors = graph.get(node);
            if (neighbors != null) {
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        path = new TreeMap<>();
                        path.put(neighbor, distance + 1);
                        queen.push(path);
                    }
                }
            }
        }

        return -1;
    }

    public static HashMap<String, List<String>> buildGraph(String[][] edges) {
        HashMap<String, List<String>> graph = new HashMap<>();
        for (String[] edge : edges) {
            String node1 = edge[0];
            String node2 = edge[1];
            if (graph.containsKey(node1)) {
                List<String> list = graph.get(node1);
                list.add(node2);
                graph.put(node1, list);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(node2);
                graph.put(node1, newList);
            }
            if (graph.containsKey(node2)) {
                List<String> list = graph.get(node2);
                list.add(node1);
                graph.put(node2, list);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(node1);
                graph.put(node2, newList);
            }
        }
        return graph;
    }
}
