class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        HashSet<Integer> suspicious = new HashSet<>();

        //I Have to create a graph
        for(int[] edge : invocations ){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }

        //mark the suspicious nodes
        dfs(k, graph, suspicious);
        for(int[] edge: invocations){
            int from = edge[0];
            int to = edge[1];
            if(!suspicious.contains(from) && suspicious.contains(to)){
                List<Integer> ans = new ArrayList<>();
                for(int i=0;i<n;i++){
                    ans.add(i);
                }
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!suspicious.contains(i)){
                ans.add(i);
            }
        }

        return ans;
        

    }

    public void dfs(int node,HashMap<Integer,List<Integer>> graph,
        HashSet<Integer> suspicious){
            if(suspicious.contains(node)){
                return;
            }
            suspicious.add(node);
            if(!graph.containsKey(node)){
                return;
            }

            for(int next: graph.get(node)){
                dfs(next,graph,suspicious);
            }
    }
}