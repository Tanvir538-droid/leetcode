class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        //first count the number of 1 in each row
        //save it into an arraylist
        int[] rowSoldierCounter = new int[mat.length];
        for(int i=0;i<mat.length;i++){
            int count = 0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            rowSoldierCounter[i] = count;
        }

        //create a treehmap <Integer,Integer> map
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            //this is called the comparator 
            (a,b) ->{
                if(a[0]!=b[0]){
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        );

        //store the value according to their index
        for(int i=0;i<rowSoldierCounter.length;i++){
            pq.offer(new int[]{rowSoldierCounter[i],i});
        }

        //then based on the conditions I need to save k weakest rows 
        //in other words their indexes into an array
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll()[1];
        } 

        //now the ans array contains the k weakest rows
        //return it

        return ans;


    }
}