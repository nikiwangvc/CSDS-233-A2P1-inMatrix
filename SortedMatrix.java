import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SortedMatrix {


    public static int[][] generateMatrix(int dim) {
        int[][] outputMatrix = new int[dim][dim];
        int n = 1;
        for (int i = 0;i<dim;i++){
            for(int j = 0;j<dim;j++){
                outputMatrix[i][j] = n;
                n++;
            }
        }
        return outputMatrix;
    }
    private static void printMatrixToFile(String fileName, int[][] matrix) throws IOException{
        Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.US_ASCII));
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                w.write(matrix[i][j] + " ");
            }
            w.write('\n');
        }
        w.close();
    }
    public static void main(String[] args) throws IOException {

        SortedMatrix.printMatrixToFile("5x5.txt",SortedMatrix.generateMatrix(5));
        SortedMatrix.printMatrixToFile("25x25.txt",SortedMatrix.generateMatrix(25));
        SortedMatrix.printMatrixToFile("125x125.txt",SortedMatrix.generateMatrix(125));
        SortedMatrix.printMatrixToFile("625x625.txt",SortedMatrix.generateMatrix(625));
        SortedMatrix.printMatrixToFile("1x1.txt",SortedMatrix.generateMatrix(1));


    }

}
