package hu.maz;

/**
 *
 * @author MAZ
 */
public class DayTwo {

    public static void main(String[] args) {
        int rows = 10;
        int length = 4;
        int[][] spreadSheet = new int[rows][length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < length; j++) {
                spreadSheet[i][j] = (int) (Math.random() * 9 + 1);
            }

        }

        DayTwo.Out(length, rows, spreadSheet);

        int[] large = new int[rows];
        int[] small = new int[rows];
        for (int i = 0; i < rows; i++) {
            large[i] = i;
            small[i] = 9;
            for (int j = 0; j < length; j++) {
                large[i] = (spreadSheet[i][j] > large[i]) ? large[i] = spreadSheet[i][j] : large[i];
                small[i] = (spreadSheet[i][j] < small[i]) ? small[i] = spreadSheet[i][j] : small[i];
            }
        }

        int[] sum = new int[rows];
        for (int i = 0; i < rows; i++) {
            sum[i] = large[i] - small[i];
        }

        for (int i = 0; i < sum.length; i++) {
            System.out.print(large[i]+" - "+small[i]+" = "+sum[i] + "\n");

        }
    }

    public static void Out(int l, int r, int[][] z) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(z[i][j] + " ");
            }
            System.out.println("");
        }

    }

}
