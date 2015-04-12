/**
 * https://leetcode.com/problems/word-search/
 *
 * AKA Boggle Game
 *
 * DFS solution, the key is to pass the visited matrix to the subroutine, and reset the value before return
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return true;

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (board[i][j] == word.charAt(0)){
                    boolean ret = exist(board, word, i, j, visited);
                    if (ret)
                        return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int x, int y, boolean[][] visited){
        if (word.length() == 0)
            return true;
        if (x<0 || x>=visited.length || y<0 || y>=visited[0].length || board[x][y] != word.charAt(0) || visited[x][y])
            return false;
        visited[x][y] = true;

        String newWord = word.substring(1);
        boolean ret =  exist(board, newWord, x, y-1, visited)
                || exist(board, newWord, x, y+1, visited)
                || exist(board, newWord, x-1, y, visited)
                || exist(board, newWord, x+1, y, visited);
        visited[x][y] = false;
        return ret;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{"ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()};
        System.out.println(new WordSearch().exist(board,"ABCB"));
    }
}
