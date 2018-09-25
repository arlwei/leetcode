/**
 * title:
 * 73.Set Matrix Zeroes
 * content：
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean zeroInFisrtRow = false, zeroInFisrtColumn = false;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                zeroInFisrtRow = true;
                break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                zeroInFisrtColumn = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //i = 1 to prevent to let row 0th to be zeroes, this will affect next for loop of column
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        //zero exists in the first row of origin matrix
        for (int j = 0; j < matrix[0].length && zeroInFisrtRow; j++) {
            matrix[0][j] = 0;
        }

        for (int i = 0; i < matrix.length && zeroInFisrtColumn; i++) {
            matrix[i][0] = 0;
        }
    }
}
