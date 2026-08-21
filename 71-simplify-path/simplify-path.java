class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] parts = path.split("/");
        for(String str: parts){
            if (str.equals("")||str.equals(".")) {
                continue;
            }
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }else{
                stack.push(str);
            }
        }

        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()){
            str.insert(0, "/"+stack.pop());
        }

        return str.length() == 0 ? "/" :str.toString();
    }
}