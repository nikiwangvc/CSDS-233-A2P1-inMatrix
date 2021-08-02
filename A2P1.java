import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class A2P1 {

    public static boolean inMatrix(int[][]matrix, int x){
        int size = matrix.length;
        //case 1: x will be compared with top left value and bottom right value
        //if x is smaller than top left value and bottom right value then return false
        if(x < matrix[0][0] || x > matrix[size-1][size-1])
            return false;
        /* case 2: x will be compared with top right value
        if x is greater than the comparedValue
        then x will be compared with the value below comparedValue
        if x is smaller than the comparedValue
        then x will be compared with the value on the left of comparedValue
        */
        int topRightColumn = size-1;
        int topRightRow = 0;
        while(topRightRow < size && topRightColumn >= 0) {
            int comparedValue = matrix[topRightRow][topRightColumn];
            if(x == comparedValue)
                return true;
            else if(x < comparedValue){
                topRightColumn--;
            }
            else {
                topRightRow++;
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        //set up a listener, listening for an input
        //input dimension and input matrix file
        Scanner scan = new Scanner(System.in);
        //gets the next integer
        int dimension = scan.nextInt();
        //gets the blank character return
        String buffer = scan.nextLine();
        //gets the fileName next line
        String fileName = scan.nextLine();
        //reads the fileName and opens the file
        File matrixFile = new File(fileName);
        //adds the file to a new allocated memory and read the matrixFile
        //and new FileReader throws a file not found exception (IOException in the method header)
        BufferedReader br = new BufferedReader(new FileReader(matrixFile));

        //create a new 2D inputMatrix with dimension by dimension
        int[][] inputMatrix = new int[dimension][dimension];
        //current line of input that is being parsed
        //initially null before while loop
        String inputLine;
        int row = 0;
        //assign the next line to input line
        //if it is not null, we can start splitting the line and convert string to int
        while((inputLine = br.readLine())!=null){
            //splitting "1 2 3" based off " "
            //For example, each line of split input should look like ["1","2","3"]
            String[] splitInput = inputLine.split(" ");
            //using for loop to convert string to int
            //insert each converted int to the matrix
            for(int i = 0; i < dimension; i++){
                int temp = Integer.parseInt(splitInput[i]);
                inputMatrix[row][i] = temp;
            }
            row++;
        }

        double runningtimeBefore = System.nanoTime();
        //9 is the worst-case scenario for the example provided since it is bottom left
        System.out.println(A2P1.inMatrix(inputMatrix,9));
        //run time difference before and after invoking inMatrix
        System.out.println(System.nanoTime() - runningtimeBefore);

        /*int[][] testMatrix = {
                {2,3,5,8},
                {4,6,7,12},
                {7,11,14,17},
                {9,13,19,21}};
        System.out.println("Value 9 exists: " + A2P1.inMatrix(testMatrix,9));
        System.out.println("Value 10 exists: " + A2P1.inMatrix(testMatrix,10));
        System.out.println("Value 6 exists: " + A2P1.inMatrix(testMatrix,6));
        System.out.println("Value 23 exists: " + A2P1.inMatrix(testMatrix,23));
        System.out.println("Value 1 exists: " + A2P1.inMatrix(testMatrix,1));
        System.out.println("Value 8 exists: " + A2P1.inMatrix(testMatrix,8));
        System.out.println("Value -1 exists: " + A2P1.inMatrix(testMatrix,-1));
         */
    }
}
