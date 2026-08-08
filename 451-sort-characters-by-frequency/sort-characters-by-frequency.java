class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(
            //this is the comparator of max heap
            (a,b)-> map.get(b)-map.get(a)
        );
        for(Map.Entry<Character,Integer> entry: map.entrySet() ){
            pq.offer(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {

            char c = pq.poll();
            int frequency = map.get(c);
            for(int i=0;i<frequency;i++){
                sb.append(c);
            }
        }
        String str = sb.toString();
        return str;
    }
}