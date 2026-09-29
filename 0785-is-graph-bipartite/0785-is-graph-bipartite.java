class Solution {

    public boolean dfs(int node,int[] color,int[][] graph){
        if (color[node]==0) {
            color[node] = 1;
        }

        for(int next : graph[node]){
            if (color[node]==color[next]) {
                return false;
            }

            if (color[next]==0) {
                if (color[node]==1) {
                    color[next]=2;
                }else{
                    color[next]=1;
                }

                if (!dfs(next, color, graph)) {
                    return false;
                }
            }
        }

        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if (!dfs(i, color, graph)) {
                return false;
            }
        }
        return true;
    }
}