class Solution {
    public int calPoints(String[] operations) {

        
        Stack<Integer> stack = new Stack<>();
        for( String str : operations){
            if (str.charAt(0)!='C' && str.charAt(0)!='D'&& str.charAt(0)!='+') {
                stack.push(Integer.parseInt(str));
            }else if (str.charAt(0)=='+') {
                int top = stack.pop();
                int topSecond = stack.peek();
                stack.push(top);
                int total = top + topSecond;
                stack.push(total);
            }else if (str.charAt(0)=='C') {
                stack.pop();
            }else{
                stack.push(stack.peek()*2);
            }
        }

        int total = 0;
        for(int num : stack){
            total+=num;
        }
        return total;
    }
}