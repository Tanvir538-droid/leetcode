import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        char[] ch = pattern.toCharArray();
        if(ch.length!=str.length){
            return false;
        }

        HashMap<String,Character> mapST = new HashMap<>();
        HashMap<Character,String> mapTS = new HashMap<>();
        for(int i =0;i<ch.length;i++){

            String a = str[i];
            char b = ch[i]; 
            if(mapST.containsKey(a)){
                if(mapST.get(a)!=b){
                    return false;
                }
            }

            if(mapTS.containsKey(b)){
                if (!mapTS.get(b).equals(a)) {
                    return false;
                }
            }

            mapST.put(a, b);
            mapTS.put(b, a);
            
        }

        return true;
    }
}