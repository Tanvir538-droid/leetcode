class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }

            char top = stack.peek();
            if (ch!=top) {
                stack.push(ch);
            }else{
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch: stack){
            sb.append(ch);
        }

        return sb.toString();
    }
}