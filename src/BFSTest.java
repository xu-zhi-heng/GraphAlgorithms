import java.util.HashMap;
import java.util.LinkedList;

public class BFSTest {
    public static void main(String[] args) {
        HashMap<String, String[]> graph = new HashMap<>();
        graph.put("a", new String[]{"b", "c"});
        graph.put("b", new String[]{"d"});
        graph.put("c", new String[]{"e"});
        graph.put("d", new String[]{"f"});
        graph.put("e", new String[]{});
        graph.put("f", new String[]{});

        breadthFirst(graph, "a");
    }

    public static void breadthFirst(HashMap<String, String[]> graph, String source) {
        LinkedList<String> queen = new LinkedList<>();

        queen.add(source);

        while (!queen.isEmpty()) {
            String current = queen.pollFirst();
            System.out.print(current + " ");

            for (String neighbor : graph.get(current)) {
                queen.push(neighbor);
            }
        }

    }
}
