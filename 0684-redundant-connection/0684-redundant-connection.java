class Solution {

    public int find(int node,int[] parent){
        if (parent[node]==node) {
            return node;
        }
        parent[node] = find(parent[node], parent);
        return parent[node];
    }
    public boolean union(int u,int v,int[] parent){
        int rootU = find(u, parent);
        int rootV = find(v, parent);
        if (rootU==rootV) {
            return false;
        }
        parent[rootV] = rootU;
        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        for(int i=0;i<=edges.length;i++){
            parent[i] = i;
        }

        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            if (!union(u, v, parent)) {
                return new int[]{u,v};
            }
        }

        return new int[]{0,0};
    }
    
}