class Solution {
    public boolean courseSequence(int course,
                                List<List<Integer>> graph,
                                int[] state,
                                int[] sequence,
                                int[] index){
        if (state[course]==1) {
            return false;
        }
        if (state[course]==2) {
            return true;
        }

        state[course] = 1;
        for(int next:graph.get(course)){
            if (!courseSequence(next, graph, state, sequence,index)) {
                return false;
            }
        }

        state[course] = 2;
        sequence[index[0]] = course;
        index[0]++;
        return true;

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pair:prerequisites){
            graph.get(pair[1]).add(pair[0]);
        }

        int[] state = new int[numCourses];
        int[] sequence = new int[numCourses];
        int[] index = new int[1];
        for(int i=0;i<numCourses;i++){
            if (!courseSequence(i, graph, state, sequence, index)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            result[i]= sequence[numCourses-1-i];
        }
        return result;
    }
}