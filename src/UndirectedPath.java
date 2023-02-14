import java.util.*;

// 无向图中判断一个点是否可以到达另外一个点
public class UndirectedPath {
    public static void main(String[] args) {
        String[][] edges = new String[][]{
                {"i", "j"},
                {"k", "i"},
                {"m", "k"},
                {"k", "l"},
                {"o", "n"},
        };

        HashMap<String, List<String>> graph = buildGraph(edges);

        System.out.println(hasPath(graph, "i", "n", new ArrayList<>()));
    }

    public static boolean hasPath(HashMap<String, List<String>> graph, String src, String dst, List<String> visited) {
        if (src.equals(dst)) return true;
        if (visited.contains(src)) {
            return false;
        } else {
            visited.add(src);
        }
        List<String> neighbors = graph.get(src);
        if (neighbors == null) return false;
        for (String neighbor : neighbors) {
            if (hasPath(graph, neighbor, dst, visited)) {
                return true;
            }
        }

        return false;
    }

    // 将边转为图
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
