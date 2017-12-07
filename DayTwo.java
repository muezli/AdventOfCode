package hu.maz;
/**
 * maz or muezli w/e
 */

public class DayTwo {
    public static void main(String[] args) {
//Number of rows in the list and the count of numbers in a row  
//Can be any number given positive number
        int rows = 10;
        int length = 4;
        int[][] spreadSheet = new int[rows][length];
//Filling that list with randoms        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < length; j++) {
                spreadSheet[i][j] = (int) (Math.random() * 9 + 1);
            }
        }
//Printing the list for reasons
        DayTwo.Out(length, rows, spreadSheet);

        int[] large = new int[rows];
        int[] small = new int[rows];
//Checking the numbers one by one, it just werks        
        for (int i = 0; i < rows; i++) {
            large[i] = i;
            small[i] = 9;
            for (int j = 0; j < length; j++) {
                large[i] = (spreadSheet[i][j] > large[i]) ? large[i] = spreadSheet[i][j] : large[i];
                small[i] = (spreadSheet[i][j] < small[i]) ? small[i] = spreadSheet[i][j] : small[i];
            }
        }
//Summing the subs and fancy printing
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += large[i] - small[i];
            if (rows - 1 != i) {
                System.out.print(large[i] + " - " + small[i] + " = " + (large[i] - small[i]) + "\n+ ");
            } else {
                System.out.print(large[i] + " - " + small[i] + " = " + (large[i] - small[i]) + "\n****** ");
            }
        }
        System.out.println("\nChecksum is: " + sum);
    }

    public static void Out(int l, int r, int[][] z) {
//Nested loops for printing this badboy        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(z[i][j] + " ");
            }
            System.out.println("");
        }

    }

}
