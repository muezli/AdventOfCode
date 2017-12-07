package hu.maz;
/**
 * maz or muezli w/e
 * Nothing is called from the package.
 *
 * The base code is an universal solution for randomly generated numbers, however the Division method
 * most likely will run to an error with random numbers.
 **/

public class DayTwo {
    public static void main(String[] args) {
//Number of rows in the list and the count of numbers in a row  
//Can be any given number positive number
//The given list was a 16 by 16 list        
        int rows = 10;
        int length = 4;

//In case of using the given list comment from here until the beginning of the commented list
        int[][] spreadSheet = new int[rows][length];
//Filling that list with randoms        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < length; j++) {
                spreadSheet[i][j] = (int) (Math.random() * 9 + 1);
            }
        }
/*      The actual list made into an array with some notepad magic
        Just uncomment it in case
        
        int[][] spreadSheet = new int[][]{
        {116, 1259, 1045, 679, 1334, 157, 277, 1217, 218, 641, 1089, 136, 247, 1195, 239, 834},
        {269, 1751, 732, 3016, 260, 6440, 5773, 4677, 306, 230, 6928, 7182, 231, 2942, 2738, 3617},
        {644, 128, 89, 361, 530, 97, 35, 604, 535, 297, 599, 121, 567, 106, 114, 480},
        {105, 408, 120, 363, 430, 102, 137, 283, 123, 258, 19, 101, 181, 477, 463, 279},
        {873, 116, 840, 105, 285, 238, 540, 22, 117, 125, 699, 953, 920, 106, 113, 259},
        {3695, 161, 186, 2188, 3611, 2802, 157, 2154, 3394, 145, 2725, 1327, 3741, 2493, 3607, 4041},
        {140, 1401, 110, 119, 112, 1586, 125, 937, 1469, 1015, 879, 1798, 122, 1151, 100, 926},
        {2401, 191, 219, 607, 267, 2362, 932, 2283, 889, 2567, 2171, 2409, 1078, 2247, 2441, 245},
        {928, 1142, 957, 1155, 922, 1039, 452, 285, 467, 305, 506, 221, 281, 59, 667, 232},
        {3882, 1698, 170, 5796, 2557, 173, 1228, 4630, 174, 3508, 5629, 4395, 180, 5100, 2814, 2247},
        {396, 311, 223, 227, 340, 313, 355, 469, 229, 162, 107, 76, 363, 132, 453, 161},
        {627, 1331, 1143, 1572, 966, 388, 198, 2068, 201, 239, 176, 1805, 1506, 1890, 1980, 1887},
        {3390, 5336, 1730, 4072, 5342, 216, 3823, 85, 5408, 5774, 247, 5308, 232, 256, 5214, 787},
        {176, 1694, 1787, 1586, 3798, 4243, 157, 4224, 3603, 2121, 3733, 851, 2493, 4136, 148, 153},
        {2432, 4030, 3397, 4032, 3952, 2727, 157, 3284, 3450, 3229, 4169, 3471, 4255, 155, 127, 186},
        {919, 615, 335, 816, 138, 97, 881, 790, 855, 89, 451, 789, 423, 108, 95, 116}
        };

*/
        
//Printing the list for reasons
        DayTwo.Out(length, rows, spreadSheet);

        int[] large = new int[rows];
        int[] small = new int[rows];
        
//Checking the numbers one by one, it just werks, large[i] could be Integer.MIN_VALUE in case of negative(?) numbers       
        for (int i = 0; i < rows; i++) {
            large[i] = 0;
            small[i] = Integer.MAX_VALUE;
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
 
 //Calling the method for divisor checking and summing the array
        int[] results = DayTwo.Division(spreadSheet, rows, length);
        int sumOfResults = 0;
        for (int i = 0; i < length; i++) {
            sumOfResults += results[i];
            if (rows - 1 != i) {
                System.out.print(results[i]+" + ");
            } else {
                System.out.println(results[i] + " = ");
            }
        }
        System.out.print("Checksum of the divison: " + sumOfResults);

    }

//Nested loops for printing the array 
    public static void Out(int l, int r, int[][] z) {       
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(z[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
 //Nested loops for looking for the whole divisors
 //With randomly generated numbers it might run to error
    public static int[] Division(int[][] a, int r, int l) {
        int[] divi = new int[l];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l; j++) {
                for (int k = j + 1; k < l; k++) {
                    if (a[i][j] % a[i][k] == 0) {
                        divi[i] = a[i][j] / a[i][k];
                    } else if (a[i][k] % a[i][j] == 0) {
                        divi[i] = a[i][k] / a[i][j];
                    }
                }
            }
        }
        return divi;
    }
}
