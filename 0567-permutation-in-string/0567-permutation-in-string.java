class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        // Frequency of characters in s1
        for (char ch : s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {

            char ch = s2.charAt(right);

            // Add character to current window
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            // Keep window size equal to s1.length()
            if (right - left + 1 > s1.length()) {

                char leftChar = s2.charAt(left);

                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (windowMap.get(leftChar) == 0) {
                    windowMap.remove(leftChar);
                }

                left++;
            }

            // Compare frequencies
            if (windowMap.equals(s1Map)) {
                return true;
            }
        }

        return false;
    }
}