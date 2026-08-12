class Solution {
    public String reorganizeString(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(
            (a,b)-> b.getValue()-a.getValue()
        );

        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            pq.offer(entry);
        }

        StringBuilder sb = new StringBuilder();
        Map.Entry<Character,Integer> previous = null;

        while (!pq.isEmpty()) {
            Map.Entry<Character,Integer> current = pq.poll();
            sb.append(current.getKey());
            current.setValue(current.getValue()-1);

            if(previous!=null && previous.getValue()>0){
                pq.offer(previous);
            }

            previous = current;
        }

        if(sb.length()!=s.length()){
            return "";
        }
        return sb.toString();
    }
}