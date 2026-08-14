public class MaximumLength {
       public int maximumLengthSubstring(String s) {
        int[] count = new int[26];
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            int c = s.charAt(right) - 'a';
            count[c]++;

            while (count[c] > 2) {
                count[s.charAt(left) - 'a']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
