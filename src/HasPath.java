import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;

import java.io.Reader;
import java.util.HashMap;
import java.util.Stack;

public class HasPath {
    public static void main(String[] args) {
        HashMap<String, String[]> graph = new HashMap<>();
        graph.put("f", new String[]{"g", "i"});
        graph.put("g", new String[]{"h"});
        graph.put("h", new String[]{});
        graph.put("i", new String[]{"g", "k"});
        graph.put("j", new String[]{"i"});
        graph.put("", new String[]{});

        System.out.println(Recursion(graph, "f", "k"));
    }

    public static boolean DFS(HashMap<String, String[]> graph, String src, String dst) {
        Stack<String> stack = new Stack<>();
        stack.push(src);

        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (current.equals(dst)) return true;
            String[] neighbors = graph.get(current);
            if (neighbors == null) {
                return false;
            } else {
                for (String neighbor : graph.get(current)) {
                    if (neighbor.equals(dst)) {
                        return true;
                    } else {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return false;
    }

    public static boolean Recursion(HashMap<String, String[]> graph, String src, String dst) {
        if (src.equals(dst)) return true;

        String[] neighbors = graph.get(src);
        if (neighbors == null) {
            return false;
        }
        for (String neighbor : neighbors) {
            if (Recursion(graph, neighbor, dst)) {
                return true;
            }
        }

        return false;
    }

}
