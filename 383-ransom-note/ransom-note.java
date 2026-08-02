class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote.length()>magazine.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        // for(char c: ransomNote.toCharArray()){
        //     map.put(c,map.getOrDefault(c,0)+1);
        // }
        for(char c: magazine.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(char c: ransomNote.toCharArray()){
            map.put(c,map.getOrDefault(c,0)-1);
            if(map.get(c)<0){
                return false;
            }
        }
        return true;
    }
}