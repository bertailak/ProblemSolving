package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import leetcode.model.Node;

public class CloneGraph {

    // https://leetcode.com/problems/clone-graph/

    public Node cloneGraph(Node node) {
        Node result = new Node();

        HashMap<Integer, Node> map = new HashMap<>();

        while (node != null) {
            if (!map.containsKey(node.val))
                map.put(node.val, new Node(node.val));
            
        }

        return result;
    }

}
