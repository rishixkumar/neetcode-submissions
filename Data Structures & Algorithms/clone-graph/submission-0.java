/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> oldNew = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        oldNew.put(node, new Node(node.val));
        q.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node neighbor : curr.neighbors) {
                if (!oldNew.containsKey(neighbor)) {
                    oldNew.put(neighbor, new Node(neighbor.val));
                    q.add(neighbor);
                }
                oldNew.get(curr).neighbors.add(oldNew.get(neighbor));
            }
        }
        return oldNew.get(node);
    }
}




