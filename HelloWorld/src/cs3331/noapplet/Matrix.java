package cs3331.noapplet;
//$Id: Matrix.java,v 1.1 2019/04/25 17:35:30 cheon Exp $

/**
* A utility class to compute multiplication of two matrices
* sequentially and concurrently.
*
* @author Yoonsik Cheon
*/
public abstract class Matrix {

 private final static String USAGE = "Usage: java Matrix size subSize";

 /**
  * Multiply matrices <code>a</code> and <code>b</code> sequentially
  * and return the result. The matrices <code>a</code> and
  * <code>b</code> must be multiplication compatible.
  */
 public static double[][] mul(double a[][], double b[][]) {
     int row = a.length;
     int col = a[0].length;
     double c[][] = new double[row][col];
     for (int i = 0; i < row; i++) {
         for (int j = 0; j < col; j++) {
             c[i][j] = 0;
             for (int k = 0; k < col; k++) {
                 c[i][j] += a[i][k] * b[k][j];
             }
         }
     }
     return c;
 }

 /**
  * Multiply matrices <code>a</code> and <code>b</code> and return
  * the result. The result is computed using multiple threads. The
  * result matrix is partitioned into a number of sub-matrices, an
  * each sub-matrix is computed using a separate thread.  The
  * matrices <code>a</code> and <code>b</code> must be
  * multiplication compatible.
  *
  * @param sizeOfSub Size of the submatrices. The result matrix is
  * partitioned into sizeOfSub x sizeOfSub submatrices.
  */
 public static double[][] tmul(double a[][], double b[][], int sizeOfSub) {
     int row = a.length;
     int size = Math.min(row, sizeOfSub); // size of sub-matrix

     //--
     //-- WRITE YOUR CODE HERE
     //-- 
     return mul(a,b);
 }
 
 /**
  * Create and return a matrix of size <code>size x size</code>
  * whose elements are filled with randomly generated numbers.
  */
 private static double[][] randomMatrix(int size) {
     double result[][] = new double[size][size];
     for (int i = 0; i < size; i++) {
         for (int j = 0; j < size; j++) {
             result[i][j] = Math.random();
         }
     }
     return result;
 }

 public static void main(String[] args) {
     if (args.length != 2) {
         System.out.println(USAGE);
         System.exit(-1);
     }

     // default in case of invalid size and sub-size.
     int size  = Integer.parseInt(args[0]);
     if (size < 1) {
         size = 200;
     }
     int subSize = Integer.parseInt(args[1]);
     if (subSize < 1) {
         subSize = 100;
     }

     // create sample matrices
     double[][] a = randomMatrix(size);
     double[][] b = randomMatrix(size);
     double[][] c, d;
     
     // time sequential calculation
     long before = System.currentTimeMillis();
     c = mul(a, b);
     long after = System.currentTimeMillis();
     long timeSeq = after - before;
     System.out.println("Sequental Time: " + timeSeq + " msec");

     // time multithreading calculation
     before = System.currentTimeMillis();
     d = tmul(a, b, subSize);
     after = System.currentTimeMillis();
     long timeThread = after - before;
     System.out.println("Threaded Time:   " + timeThread + " msec");
     System.out.println("Ratio (mul/seq): " + (float) timeSeq / timeThread);

     // verify the correctness of multithreading algorithm
     for (int i = 0; i < size; i++) {
         for (int j = 0; j < size; j++) {
             if ((Math.abs(c[i][j] - d[i][j]) > 1.0E-6)) {
                 System.out.println("Error!");
                 System.exit(-1);
             }
         }
     }
 }
}