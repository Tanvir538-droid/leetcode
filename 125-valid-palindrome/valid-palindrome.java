class Solution {
    public boolean isPalindrome(String s) {
       String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
       
       int length = cleaned.length();
       int j = length-1;
       for(int i=0;i<length/2;i++){
        if (cleaned.charAt(i)!=cleaned.charAt(j)) {
            
            return false;
        }else{
            j--;
        }
       }
       return true;
    }
}

