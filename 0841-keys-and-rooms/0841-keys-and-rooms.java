
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[rooms.size()];
        queue.add(0);
        visited[0] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int room = queue.poll();
            for(int key:rooms.get(room)){
                if (!visited[key]) {
                    visited[key] = true;
                    count++;
                    queue.offer(key);
                }
            }
        }

        return count == rooms.size();
    }
}