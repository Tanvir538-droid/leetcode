class Solution {
    public boolean isAnagram(String s, String t) {


        if(s.length() != t.length()){
            return false;
        }
        char[] arr1 = s.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();

        //increase of count the frequency of the char in the string
        for(char c: arr1){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        char[] arr2 = t.toCharArray();

        //now decrease the frequency 
        for(char c:arr2){
            if(!map.containsKey(c)){
                return false;
            }
            map.put(c,map.get(c)-1);
            if(map.get(c)<0){
                return false;
            }

            
        }
        return true; 
    }
}