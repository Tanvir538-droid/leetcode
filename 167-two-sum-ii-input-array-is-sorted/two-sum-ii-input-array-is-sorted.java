class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int first;
        int last = numbers[numbers.length -1];
        int[] result = new int[2];
        int i=0;
        int j=numbers.length - 1;
        while (i < j) {

    int sum = numbers[i] + numbers[j];

    if (sum == target) {
        return new int[]{i + 1, j + 1};
    }

    if (sum < target) {
        i++;
    } else {
        j--;
    }
}
        return result;
    }
}