//leetcode question no->3085(EASY)
class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                
                int j = i;
                while (j < n && word.charAt(j) == word.charAt(i - 1)) {
                    j++;
                }

                int groupLen = j - (i - 1);
                count += (groupLen - 1);

                i = j - 1;
            }
        }

        return count;
    }
}
