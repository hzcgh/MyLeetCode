import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * For constant space complexity solution, see http://fisherlei.blogspot.com/2013/01/leetcode-set-matrix-zeroes.html
 * The basic idea is to store the rows/columns information in the first row/ first column
 */
public class SetMatrixZeros {

    /* Space complexity O(m+n)*/
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if (matrix[i][j] == 0){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        rows.stream().forEach(i->setRowZeros(matrix,i));
        columns.stream().forEach(i->setColumnZeros(matrix,i));
    }

    public void setRowZeros(int[][] matrix, int row){
        int[] rows = matrix[row];
        for(int i=0;i<rows.length;i++){
            rows[i] = 0;
        }
    }

    public void setColumnZeros(int[][] matrix, int column){
        for(int i=0;i<matrix.length;i++){
            matrix[i][column] = 0;
        }
    }
}
