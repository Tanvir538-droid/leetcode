class Solution {
    public boolean vowelChecker(char ch){
        if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int counter = 0;
        for(int i=0;i< k;i++){
            char ch = s.charAt(i);
            if (vowelChecker(ch)) {
                counter++;
            }
        }
        int maxCounter = counter;

        for(int i=k;i<s.length();i++){
            if (vowelChecker(s.charAt(i-k))) {
                counter--;
            }
            if (vowelChecker(s.charAt(i))) {
                counter++;
            }
            if (counter>maxCounter) {
                maxCounter = counter;
            }
        }

        return maxCounter;
    }
} 