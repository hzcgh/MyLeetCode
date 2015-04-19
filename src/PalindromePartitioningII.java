/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 *
 * DP solution, inspired by:
 * http://yucoding.blogspot.com/2013/08/leetcode-question-133-palindrome.html
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        int n = s.length();
        int[] table = new int[n];
        boolean[][] palindromeTable = new boolean[n][n];

        // Odd length
        for (int i = 0; i < n; i++) {
            int start = i;
            int end = i;
            boolean isPalindrome = true;

            while (start >= 0 && end < n) {
                if (isPalindrome) {
                    if (s.charAt(start) != s.charAt(end))
                        isPalindrome = false;
                }
                palindromeTable[start][end] = isPalindrome;
                start--;
                end++;
            }
        }

        // Even length
        for (int i = 0; i < n - 1; i++) {
            int start = i;
            int end = i + 1;

            boolean isPalindrome = true;

            while (start >= 0 && end < n) {
                if (isPalindrome) {
                    if (s.charAt(start) != s.charAt(end))
                        isPalindrome = false;
                }
                palindromeTable[start][end] = isPalindrome;
                start--;
                end++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (palindromeTable[0][i]) {
                table[i] = 0;
                continue;
            }

            table[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (palindromeTable[j][i]) {
                    if (table[j - 1] + 1 < table[i])
                        table[i] = table[j - 1] + 1;
                }
            }
        }
        return table[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioningII().minCut("aabccee"));
    }
}
