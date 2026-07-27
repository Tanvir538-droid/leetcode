

class Solution {

    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        return pad("", digits);
    }

    public List<String> pad(String p, String up) {

        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();

        int digit = up.charAt(0) - '0';

        String[] keypad = {
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };

        String letters = keypad[digit];

        for (int i = 0; i < letters.length(); i++) {
            list.addAll(pad(p + letters.charAt(i), up.substring(1)));
        }

        return list;
    }
}