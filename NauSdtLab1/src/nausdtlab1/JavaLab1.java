/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nausdtlab1;

import java.util.Random;

/**
 *
 * @author Anastasiy
 */
public class JavaLab1 {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Developer me = new Developer("Tovstik", "A.V");
        me.printName();
    
        int N = 7;

        int[][] A = new int[N][N];
        
        Random randomGen = new Random();
        
        System.out.println("\nOriginal Array A");
        for (int i = 0; i < N; i++) {
            System.out.print("[Row " + i+"]");
            for (int j = 0; j < N; j++) {
                int randomNum = randomGen.nextInt(100);
                A[i][j] = randomNum;
                System.out.print(" " + A[i][j]);
            }
            System.out.println();
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int memo = A[i][N-1 - j];
                A[i][N-1 - j] = A[i][j];
                A[i][j] = memo;
            }
        }
        
        System.out.println("\nSorted Array A");
        for (int i = 0; i < N; i++) {
            System.out.print("[Row " + i+"]");
            for (int j = 0; j < N; j++) {
                System.out.print(" " + A[i][j]);
            }
            System.out.println();
        }
    }
}
