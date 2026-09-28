class Solution {
    public boolean dfs(int course,List<List<Integer>> graph,int[] state){
        //this condition means we found a cycle
        if (state[course]==1) {
            return false;
        }
        if (state[course]==2) {
            return true;
        }

        //currently visiting this course
        state[course] = 1;
        for(int next: graph.get(course)){
            if (!dfs(next, graph, state)) {
                return false;
            }
        }

        state[course] = 2;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        //this will create a list from 0 to numCourses-1
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pair: prerequisites){
            graph.get(pair[1]).add(pair[0]);
        }

        ///state 0 = not visited
        ///state 1 = currently visiting
        ///state 2 = completely visited
        
        int[] state = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if (!dfs(i,graph,state)) {
                return false;
            }
        }
        return  true;
    }
}