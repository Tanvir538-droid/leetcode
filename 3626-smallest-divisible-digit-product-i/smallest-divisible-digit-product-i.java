class Solution {
    public int smallestNumber(int n, int t) {
        return answer(n, t);

    }

    public int answer(int n, int t){
        int length = String.valueOf(n).length();
        String str = String.valueOf(n);
        int product = 1;
        int[] arr = new int[length];
        for(int i=0;i<length;i++){
            arr[i] = str.charAt(i) - '0';
            product = product * arr[i];
        }

        if(product%t==0){
            return n;
        }

        int result = answer(n+1, t);
        return result;
    }
}