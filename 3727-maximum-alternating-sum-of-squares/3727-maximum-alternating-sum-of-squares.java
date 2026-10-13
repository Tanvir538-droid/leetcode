class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] faker = new long[nums.length];
        for(int i=0;i<nums.length;i++){
            faker[i] =(long) nums[i]*nums[i];
        }
        Arrays.sort(faker);
        int length = faker.length;
        int mid = length/2;
        long s1 = 0;
        long s2 = 0;
        for(int i=0;i<mid;i++){
            s1 += faker[i];
        }
        for(int i=mid;i<length;i++){
            s2 +=  faker[i];
        }

        return s2-s1;
    }
}