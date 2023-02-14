import java.util.HashMap;
import java.util.Stack;

public class DFSTest {
    public static void main(String[] args) {

        HashMap<String, String[]> graph = new HashMap<>();
        graph.put("a", new String[]{"b", "c"});
        graph.put("b", new String[]{"d"});
        graph.put("c", new String[]{"e"});
        graph.put("d", new String[]{"f"});
        graph.put("e", new String[]{});
        graph.put("f", new String[]{});

        depthFirstPrint(graph, "a");

        System.out.println();

        depthFirstPrintByrRecursion(graph, "a");
    }

    /**
     * DFS遍历图中的所有节点信息
     * @param graph: 图信息
     * @param source: 从哪一个节点出发
     */
    public static void depthFirstPrint(HashMap<String, String[]> graph, String source) {
        Stack<String> stack = new Stack<>();

        stack.push(source);

        while (!stack.isEmpty()) {
            String current = stack.pop();
            System.out.print(current + " ");
            String[] neighbors = graph.get(current);
            for (String neighbor : neighbors) {
                stack.push(neighbor);
            }
        }
    }
    // 递归实现DFS
    public static void depthFirstPrintByrRecursion(HashMap<String, String[]> graph, String source) {
        System.out.print(source + " ");
        for (String neighbor : graph.get(source)) {
            depthFirstPrintByrRecursion(graph, neighbor);
        }
    }
}
