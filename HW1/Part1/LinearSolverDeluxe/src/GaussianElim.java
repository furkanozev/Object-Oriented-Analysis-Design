/**
 *  @author Furkan Ozev
 *  @since 20-11-2020
 *  Homework 1 - 161044036
 *
 *  It is class of Gaussian Elimination method to solve linear equations.
 */
public class GaussianElim implements LinearSolverMethods {
    /***
     *  To keep value of epsilon
     */
    private final double EPSILON = 1e-5;
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
        size  = rightMatrix.length;

        if(singularity(leftMatrix, rightMatrix) != 1)
            return null;

        double[] res = bsubstitution(leftMatrix, rightMatrix);

        return res;
    }

    /***
     * Controls the singularity property of the matrix.
     * @param leftMatrix    double[][] It contains the coefficients in the equations.
     * @param rightMatrix   double[] It contains the results of the equations.
     * @return  int if non-singular 1, singular -1
     */
    private int singularity(double[][] leftMatrix, double[] rightMatrix){
        for(int i = 0; i < size; i++){
            int max = i;

            for(int j = i+1; j < size; j++){
                if(Math.abs(leftMatrix[j][i]) > Math.abs(leftMatrix[max][i]))
                    max = j;
            }

            swap(rightMatrix, i, max);
            swap(leftMatrix, i, max);

            if(Math.abs(leftMatrix[i][i]) <= EPSILON)
                return -1;

            for(int j = i+1; j < size; j++){
                double alpha = leftMatrix[j][i] / leftMatrix[i][i];
                rightMatrix[j] -= alpha * rightMatrix[i];

                for(int z = i; z < size; z++){
                    leftMatrix[j][z] -= alpha * leftMatrix[i][z];
                }
            }
        }

        return 1;
    }

    /***
     * Back substitution of matrix
     * @param leftMatrix    double[][] It contains the coefficients in the equations.
     * @param rightMatrix   double[] It contains the results of the equations.
     * @return  double[]    Solution array.
     */
    private double[] bsubstitution(double[][] leftMatrix, double[] rightMatrix){
        double[] res = new double[size];
        double sum;

        for (int i = size - 1; i >= 0; i--) {
            sum = 0;

            for (int j = i + 1; j < size; j++) {
                sum += res[j] * leftMatrix[i][j];
            }

            res[i] = (rightMatrix[i] - sum) / leftMatrix[i][i];
        }

        return res;
    }

    /***
     * Swap 2 items in array.
     * @param matrix    double[]   An matrix for swapping
     * @param i int index of first item
     * @param j int index of second item
     */
    private void swap(double[] matrix, int i, int j)
    {
        double temp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = temp;
    }

    /***
     * Swap 2 column in array
     * @param matrix double[][]  An matrix for swapping
     * @param i int index of first row
     * @param j int index of second row
     */
    private void swap(double[][] matrix, int i, int j)
    {
        double[] temp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = temp;
    }
}