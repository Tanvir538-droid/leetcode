class Solution {
    public int maxDepth(String s) {
        char[] ch = s.toCharArray();
        int max = 0;
        int counter = 0;
        for(int i=0;i<ch.length;i++){
            if (ch[i]=='(') {
                counter++;
                max = Math.max(max,counter);
            }
            if (ch[i]==')') {
                counter--;
            }
        }

        return max;
    }
}