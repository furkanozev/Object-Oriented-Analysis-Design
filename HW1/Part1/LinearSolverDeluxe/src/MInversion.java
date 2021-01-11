/**
 *  @author Furkan Ozev
 *  @since 20-11-2020
 *  Homework 1 - 161044036
 *
 *  It is class of Matrix Inversion method to solve linear equations.
 */
public class MInversion implements LinearSolverMethods {
    /***
     * To keep length of matrix
     */
    private int size;

    /***
     * It takes equations, then solve and return solution.
     * @param leftMatrix    double[][] It contains the coefficients in the equations.
     * @param rightMatrix   double[] It contains the results of the equations.
     * @return  double[]    Solution array or null if it has no solution.
     */
    @Override
    public double[] SolveEquation(double[][] leftMatrix, double[] rightMatrix){
        size = rightMatrix.length;

        double[][] inverse = InverseMatrix(leftMatrix);

        if (inverse == null)
            return null;

        double[] res = MultiplyMatrices(inverse, rightMatrix);

        return res;
    }

    /***
     * Multiply left matrix to right matrix.
     * row == column => (row x column) . (row x 1) = (row x 1) So, return double[]
     * @param leftMatrix    double[][] It contains the coefficients in the equations.
     * @param rightMatrix   double[] It contains the results of the equations.
     * @return  double[]    result of multiplication.
     */
    private double[] MultiplyMatrices(double[][] leftMatrix, double[] rightMatrix){
        double[] res = new double[size];
        double sum;
        for(int i = 0; i < size; i++){
            sum = 0.0;
            for(int j = 0; j < size; j++)
                sum += leftMatrix[i][j] * rightMatrix[j];
            res[i] = sum;
        }
        return res;
    }

    /***
     * Takes the inverse of the matrix.
     * If the determinant is zero, it is a singular matrix.
     * So there is no inverse, it returns null.
     * @param matrix    double[][] matrix to inverse
     * @return  double[][] if exist inverse matrix, else null
     */
    private double[][] InverseMatrix(double[][] matrix) {

        double det = determinant(matrix);
        if(Double.isNaN(det) || det == 0)
            return null;

        int index[] = new int[size];
        double extendRight[][] = new double[size][size];

        for(int i = 0; i < size; i++)
        {
            extendRight[i][i] = 1.0;
            index[i] = i;
        }

        Triangle(matrix, index);

        for (int i = 0; i < size-1; i++) {
            for (int j = i+1; j < size; j++) {
                for (int z = 0; z < size; z++) {
                    extendRight[index[j]][z] -= matrix[index[j]][i] * extendRight[index[i]][z];
                }
            }
        }

        return bsubstitution(matrix, extendRight, index);

    }

    /***
     * Back substitution of matrix
     * @param leftMatrix    double[][] It contains the coefficients in the equations.
     * @param rightMatrix   double[] It contains the results of the equations.
     * @param index double[]    Index matrix for inverse
     * @return  double[][]    Last matrix.
     */
    private double[][] bsubstitution(double[][] leftMatrix, double[][] rightMatrix, int[] index){
        double[][] res = new double[size][size];
        for (int i = 0; i < size; i++)  {
            res[size-1][i] = rightMatrix[index[size-1]][i] / leftMatrix[index[size-1]][size-1];

            for (int j = size-2; j >= 0; j--) {
                res[j][i] = rightMatrix[index[j]][i];

                for (int z = j+1; z < size; z++) {
                    res[j][i] -= leftMatrix[index[j]][z] * res[z][i];
                }

                res[j][i] /= leftMatrix[index[j]][j];
            }
        }

        return res;
    }

    /***
     * Transforms matrix to an upper triangular matrix.
     * @param leftMatrix    double[][] It contains the coefficients in the equations.
     * @param index double[]    Index matrix for inverse
     */
    private void Triangle(double leftMatrix[][], int index[]) {
        double temp[] = new double[size];
        double temp1, temp2;

        for(int i = 0; i < size; i++){
            temp1 = 0;

            for(int j = 0; j < size; j++) {
                temp2 = Math.abs(leftMatrix[i][j]);

                if(temp2 > temp1)
                    temp1 = temp2;
            }

            temp[i] = temp1;
        }

        int temp3 = 0;
        double pivot1 = 0;
        double pivot2 = 0;

        for (int i = 0; i < size-1; i++) {
            pivot2 = 0;

            for (int j = i; j < size; j++) {
                pivot1 = Math.abs(leftMatrix[index[j]][i]);
                pivot1 /= temp[index[j]];

                if (pivot1 > pivot2) {
                    pivot2 = pivot1;
                    temp3 = i;
                }
            }

            int temp4 = index[temp3];
            index[temp3] = index[i];
            index[i] = temp4;

            for (int j = i + 1; j < size; j++) {
                double pj = leftMatrix[index[j]][i]/leftMatrix[index[i]][i];
                leftMatrix[index[j]][i] = pj;

                for (int z = i + 1; z < size; z++) {
                    leftMatrix[index[j]][z] -= pj * leftMatrix[index[i]][z];
                }
            }
        }
    }

    /***
     * To check singularity, calculate determinant of matrix.
     * @param matrix    double[][]  matrix to calculate determinant
     * @return  double  determinant value
     */
    public double determinant (double[][] matrix) {
        double temp[][];
        double res = 0;

        if (matrix.length == 1)
            return matrix[0][0];

        else if (matrix.length == 2)
            return ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));

        for (int i = 0; i < matrix[0].length; i++){
            temp = new double[matrix.length-1][matrix[0].length-1];

            for (int j = 1; j < matrix.length; j++){
                for (int z = 0; z < matrix[0].length; z++){
                    if (z < i){
                        temp[j-1][z] = matrix[j][z];
                    }
                    else if (z > i){
                        temp[j-1][z-1] = matrix[j][z];
                    }
                }
            }

            res += determinant (temp) * matrix[0][i] * Math.pow (-1, (double) i);
        }

        return res;
    }
}
