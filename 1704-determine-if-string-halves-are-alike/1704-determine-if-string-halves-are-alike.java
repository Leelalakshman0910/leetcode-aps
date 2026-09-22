class Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;

        String vowels = "aeiouAEIOU";
        int n = s.length();

        // First half: add vowels
        for (int i = 0; i < n / 2; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                count++;
            }
        }

        // Second half: subtract vowels
        for (int i = n / 2; i < n; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                count--;
            }
        }

        return count == 0;
    }
}