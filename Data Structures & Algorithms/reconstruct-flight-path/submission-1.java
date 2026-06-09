class Solution {
    private void dfs(String from, List<String> res, Map<String, PriorityQueue<String>> graph) {

        PriorityQueue<String> destinations = graph.get(from);
        while (destinations != null && !destinations.isEmpty()) {
            String to = destinations.poll();
            dfs(to, res, graph);
        }

        res.add(from);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        List<String> res = new ArrayList<>();
        dfs("JFK", res, graph);
        Collections.reverse(res);
        return res;
    }
}
