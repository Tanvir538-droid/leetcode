class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            //the base case
            if(stack.isEmpty()){
                stack.push(ch);
                continue;
            }

            char top = stack.peek();
            if(ch==top){
                stack.push(ch);
                continue;
            }else if (Character.toUpperCase(ch)==top || Character.toUpperCase(top)==ch) {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
         StringBuilder sb = new StringBuilder();
        for(char ch: stack){
            sb.append(ch);
        }

        return sb.toString();
    }
}

