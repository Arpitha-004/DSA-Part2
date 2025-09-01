class Graph {
    List<List<int[]>> adj; // 0->2 cost 5 then adj[0]->{2,5} 
// adj = [
//   [ {2,5}, {1,2} ],   
//   [ {2,1} ],          
//   [ ],                
//   [ {0,3} ]           
// ]
    public Graph(int n, int[][] edges) {
        adj = new ArrayList<>();
        for(int i=0;i<n;i++){   //0->3 create a empty list
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){    //to make [{},{}]->in adj[from]->add {to,cost}
            addEdge(edge);
        }
    }
    
    public void addEdge(int[] edge) {   //edge=[0,2,5]
        adj.get(edge[0]).add(new int[]{edge[1],edge[2]}); //get adj[0] -> add {2,5}
    }
    
    public int shortestPath(int node1, int node2) {
        // find shortest b/w [3,2]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0])); 
        //[(cost,node), ...] min heap compared on cost
        int n = adj.size();
        int[] costForNode = new int[n];
        Arrays.fill(costForNode,Integer.MAX_VALUE); //dijistra's cost init to infinity
        costForNode[node1]=0;
        pq.offer(new int[]{0,node1});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curCost=cur[0], curNode=cur[1];
            if(curNode==node2)
                return curCost;
            
            if(curCost > costForNode[curNode])
                continue;

            for(int[] neigh : adj.get(curNode)){
                int neNode=neigh[0], neCost=neigh[1];
                int newCost = curCost + neCost;

                if(newCost < costForNode[neNode]){  
//if neighbor cost is less than the it's own cost update it 
//shortestpath(3,2) (3,0)=3 , (0,2)=3+5=8 , (0,1)=3+2=5 -> (1,2)=5+1=6 ==> shortest is 6 from 3->0->1->2
                    costForNode[neNode] = newCost;
                    pq.offer(new int[]{newCost,neNode});
                }
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */