class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer>set = new HashSet<>();

        if(n==1){
            return true;
        }
        while(n!=1){
            String s = String.valueOf(n);
            int[] arr = new int[s.length()];
            int sum = 0;
            for(int i = 0; i < s.length() ;i++){
                arr[i] = s.charAt(i) - '0';
                sum = sum + arr[i] * arr[i];
            }
            if(sum == 1){
                return true;
            }
            if(set.contains(sum)){
                return false;
            }else{
                set.add(sum);
                n = sum;
            }

            
        }
        return false;
    }

    
}