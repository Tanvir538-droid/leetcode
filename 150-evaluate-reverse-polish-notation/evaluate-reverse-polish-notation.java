class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();;
        for(String str: tokens){
            
               
                if (str.equals("+")) {
                     int topFirst = stack.pop();
                int topSecond = stack.pop();
                    stack.push(topFirst+topSecond);
                }else if (str.equals("-")) {
                     int topFirst = stack.pop();
                int topSecond = stack.pop();
                    stack.push(-topFirst+topSecond);
                }else if (str.equals("*")) {
                     int topFirst = stack.pop();
                int topSecond = stack.pop();
                    stack.push(topFirst*topSecond);
                }else if (str.equals("/")) {
                     int topFirst = stack.pop();
                int topSecond = stack.pop();
                    stack.push(topSecond/topFirst);
                }else{
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }
}