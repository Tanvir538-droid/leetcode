class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(char ch1: s.toCharArray()){
            if (ch1=='#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            }else{
                stack1.push(ch1);
            }
        }

        for(char ch2: t.toCharArray()){
            if (ch2=='#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            }else{
                stack2.push(ch2);
            }
        }

        return stack1.equals(stack2);
    }
}