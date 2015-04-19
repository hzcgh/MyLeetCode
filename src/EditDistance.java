/**
 * https://leetcode.com/problems/edit-distance/
 *
 * See:
 * https://web.stanford.edu/class/cs124/lec/med.pdf
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] table = new int[m+1][n+1];  // Gotcha 1: Deal with empty word1 or word2
        for(int i=0;i<=m;i++)
            table[i][0] = i;

        for(int i=0;i<=n;i++)
            table[0][i] = i;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int deletion = table[i-1][j] + 1;
                int insertion = table[i][j-1] + 1;
                int substitution = (word1.charAt(i-1) == word2.charAt(j-1)?0:1) + table[i-1][j-1];  // Gotcha 2: charAt should be index -1, since the first index is for empty string
                table[i][j] = Math.min(Math.min(insertion,deletion), substitution);
            }
        }

        return table[m][n];
    }
}
