class Pair {
    int distance, node;
    
    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}
class Solution {
    static int[] dijkstra(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj, int start) {
        
        
        //Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        
        //Priority queue with Pairs<distance from start, node>.....arranged distance wise
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.distance - p2.distance);//distance or node....by which pq will arrange itself
        pq.offer(new Pair(0, start));
        
        
        //Dijkstra's Algorithm
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int dis = p.distance;
            int node = p.node;

            for(int i=0;i<adj.get(node).size();i++){
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        //Return the array where dist[i]=distance of i from start
        return dist;
        
    }
};
