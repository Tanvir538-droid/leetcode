class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();;
        for(String str: tokens){
            if (str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")) {
                int topFirst = stack.pop();
                int topSecond = stack.pop();
                if (str.equals("+")) {
                    stack.push(topFirst+topSecond);
                }
                if (str.equals("-")) {
                    stack.push(-topFirst+topSecond);
                }
                if (str.equals("*")) {
                    stack.push(topFirst*topSecond);
                }
                if (str.equals("/")) {
                    stack.push(topSecond/topFirst);
                }
            }else{
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }
}