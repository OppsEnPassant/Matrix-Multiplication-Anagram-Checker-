import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Question1 {

 //FileNotFoundException and InputMismatchException are explicitly caught in this method using help from an Ai source
    public static void main(String args[]) {
        try {
            File file = new File("C:\\Users\\weshicksstan\\Downloads\\matrices.txt");
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] matrices = line.split(";");

                if (matrices.length != 2) {
                    System.out.println("Invalid format: Each line should contain two matrices separated by a semi-colon (;).");
                    continue;
                }

                int[][] A = parseMatrix(matrices[0]);
                int[][] B = parseMatrix(matrices[1]);

                if (A == null || B == null) {
                    System.out.println("Invalid matrix format.");
                    continue;
                }

                int m = A.length;
                int n = B[0].length;
                int p = B.length;

                if (m < 1 || n < 1 || p < 1 || m > 5 || n > 5 || p > 5) {
                    System.out.println("Invalid matrix dimensions. Dimensions must be integers between 1 and 5.");
                    continue;
                }

                if (A[0].length != p) {
                    System.out.println("Matrix orders can't be multiplied with each other.");
                    continue;
                }

                int[][] result = matrixMultiplication(A, B);

                System.out.println("Matrix Product:");
                printMatrix(result);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: matrices.txt");
        } catch (InputMismatchException e) {
            System.err.println("Invalid input format in matrices.txt");
        }
    }

    //The following piece of code snippet was took from Stackoverflow,the basic idea is to read each line and parse out CSV
    private static int[][] parseMatrix(String matrixString) throws InputMismatchException {
        String[] rows = matrixString.trim().split(",");
        int numRows = rows.length;
        if (numRows == 0) return null;
        int numCols = rows[0].split("\\s+").length;
        int[][] matrix = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            String[] elements = rows[i].trim().split("\\s+");
            if (elements.length != numCols) return null;
            for (int j = 0; j < numCols; j++) {
                try {
                    matrix[i][j] = Integer.parseInt(elements[j]);
                } catch (NumberFormatException e) {
                    throw new InputMismatchException("Non-integer value in matrix.");
                }
            }
        }
        return matrix;
    }

    public static int[][] matrixMultiplication(int[][] A, int[][] B) {
        int m = A.length;
        int n = B[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
