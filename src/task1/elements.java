/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Esteban
 */
public class elements {
    
    //comment from bazantm
    
    private int elements[][];
    private int rowA, columA, rowB, columB;
    private int max = 20, min = -10;
    private int valuesColums[], columsToChangeA[], columsToChangeB[];
    private int count = 0;
    private boolean swap = false;

    public elements() {

    }
    Random rd = new Random();

    public void assignValues() {
        this.rowA = rd.nextInt(6) + 1;
        this.rowB = rd.nextInt(6) + 1;
        this.columA = rd.nextInt(6) + 1;
        this.columB = rd.nextInt(6) + 1;
        this.elements = new int[this.rowA][this.columA];
       // this.mB = new int[this.rowB][this.columB];
       // this.mC = new int[this.rowA][this.columA];
      //  this.mD = new int[this.rowB][this.columB];
        this.valuesColums = new int[this.columA];
        this.columsToChangeA = new int[this.columA];
        this.columsToChangeB = new int[this.columB];
        System.out.println("ROWA:" + rowA);
        System.out.println("columA:" + columA);
        System.out.println("ROWB:" + rowB);
        System.out.println("columB:" + columB);
    }

    public void generateMatrix() {

        //MatrixA
        for (int i = 0; i < this.rowA; i++) {

            for (int j = 0; j < this.columA; j++) {

                this.elements[i][j] = rd.nextInt(this.max) % (this.max - this.min + 1) + this.min;
            }
        }
        //MatrixB
       /* for (int i = 0; i < this.rowB; i++) {

            for (int j = 0; j < this.columB; j++) {

                this.mB[i][j] = rd.nextInt(this.max) % (this.max - this.min + 1) + this.min;
            }
        }
        //Show the matrix
        for (int i = 0; i < this.rowA; i++) {

            for (int j = 0; j < this.columA; j++) {

                System.out.print(" " + elements[i][j]);

            }
            System.out.println("\t");
        }
        System.out.println("\t");
        for (int i = 0; i < this.rowB; i++) {

            for (int j = 0; j < this.columB; j++) {

                System.out.print(" " + mB[i][j]);

            }
            System.out.println("\t");
        
        }
*/
    }

    public void countColumsMatrixA() {

        int aux = 0;
        for (int i = 0; i < this.columA; i++) {
            this.count = 0;
            for (int j = 0; j < this.rowA; j++) {

                aux = this.elements[j][i];
                this.count = aux + this.count;
            }
            if (this.count % 2 == 0) {
                this.valuesColums[i] = 0;
            } else {
                this.valuesColums[i] = 1; //It´s odd
            }

        }
    }

    public void checkColumsMatrixB() {

        int aux = 0;

        if (this.rowA == this.rowB) {

            for (int i = 0; i < this.columsToChangeA.length; i++) {

                if (this.valuesColums[i] == 1) { //If is 1, check if in MatrixB there is a column

                    if (this.columB - i > 0) {  //If there is relevant column, set 1, if not set 0.

                        this.columsToChangeA[i] = 1;
                    } else {
                        this.columsToChangeA[i] = 0;
                    }
                } else {                         //Set 0 

                    this.columsToChangeA[i] = 0;
                }
            }

            if (this.columA >= this.columB) {

                for (int i = 0; i < this.columsToChangeB.length; i++) {

                    if (this.columsToChangeA[i] == 1) {

                        this.columsToChangeB[i] = 1;
                    } else {
                        this.columsToChangeB[i] = 0;
                    }
                }

            } else {

                aux = this.columsToChangeB.length - this.columsToChangeA.length;
                for (int i = 0; i < this.columsToChangeA.length; i++) {

                    if (this.columsToChangeA[i] == 1) {

                        this.columsToChangeB[i] = 1;
                    } else {
                        this.columsToChangeB[i] = 0;
                    }
                }

                for (int i = this.columsToChangeA.length; i < this.columsToChangeA.length + aux; i++) {

                    this.columsToChangeB[i] = 0;
                }
            }
        } else {

            System.out.println("There are not columns to change");
        }

        for (int i = 0; i < this.columsToChangeA.length; i++) {
            System.out.println("COLUMNAS CAMBIAR EN A: " + this.columsToChangeA[i]);
        }

        for (int i = 0; i < this.columsToChangeB.length; i++) {
            System.out.println("COLUMNAS CAMBIAR EN B: " + this.columsToChangeB[i]);
        }

        /*for (int i = 0; i < this.columsToChangeB.length; i++) {
            System.out.println("COLUMNAS A : " + this.valuesColums[i]);
            System.out.println("COLUMNAS CAMBIADAS: " + this.columsToChangeB[i]);
        }*/
    }

    public void swapColumn() throws NumberOfRowsException  {
        int count = 0;

        //int dif=0;
        //  int aux = 0;
        //Same numbers of rows
        if (this.rowA == this.rowB) {

            //MatrixC
            for (int i = 0; i < this.rowA; i++) {

                for (int j = 0; j < this.columA; j++) {

                    if (this.columsToChangeA[j] == 1) {
                        /* aux = this.mB[i][j];
                        this.mC[i][j] = aux;*/
                        this.mC[i][j] = this.mB[i][j];
                    } else {
                        /* aux = this.elements[i][j];
                    this.mC[i][j] = aux;*/
                        this.mC[i][j] = this.elements[i][j];
                    }
                }
            }

            for (int i = 0; i < this.rowA; i++) {

                for (int j = 0; j < this.columA; j++) {

                    System.out.print(" " + mC[i][j]);
                }
                System.out.println("\t");
            }

            //MatrixD
            for (int i = 0; i < this.rowB; i++) {

                for (int j = 0; j < this.columB; j++) {

                    if (this.columsToChangeB[j] == 1) {
                        /* aux = this.mB[i][j];
                        this.mC[i][j] = aux;*/
                        this.mD[i][j] = this.elements[i][j];
                    } else {
                        /* aux = this.elements[i][j];
                    this.mC[i][j] = aux;*/
                        this.mD[i][j] = this.mB[i][j];
                    }
                }
            }

            for (int i = 0; i < this.rowB; i++) {

                for (int j = 0; j < this.columB; j++) {

                    System.out.print(" " + mD[i][j]);
                }
                System.out.println("\t");
            }

            for (int l = 0; l < this.columsToChangeA.length; l++) {

                if (this.columsToChangeA[l] == 1) {
                    count = count++;
                }
            }
            if (count == 0) {
                System.out.println("It is not possible change the matrix because the conditions are not correct");
            }

        } else {

            throw new NumberOfRowsException("The numbers of row aren´t the same");
          //  System.out.println("No se cambian por las filas");
        }
    }

    public void writeBefore() throws IOException {

        FileWriter file = new FileWriter("C:\\Users\\esteb\\OneDrive\\Documentos\\NetBeansProjects\\Task1\\file.txt");

        file.write("MatrixA: \n");

        for (int i = 0; i < this.rowA; i++) {

            for (int j = 0; j < this.columA; j++) {

                file.write(" " + elements[i][j]);

            }
            file.write("\n");
        }

        file.write("MatrixB: \n");

        for (int i = 0; i < this.rowB; i++) {

            for (int j = 0; j < this.columB; j++) {

                file.write(" " + mB[i][j]);

            }
            file.write("\n");
        }

        file.close();
    }

    /*public void writeAfter() throws IOException {

        for (int l = 0; l < this.columsToChangeA.length; l++) {

            if (this.columsToChangeA[l] == 1) {
                count = count++;
            }
        }
        if (count == 0) {
            System.out.println("The matrix didn´t swap the columns");
        } else {
            FileWriter file = new FileWriter("C:\\Users\\esteb\\OneDrive\\Documentos\\NetBeansProjects\\Task1\\file.txt");

            file.write("MatrixC: \n");

            for (int i = 0; i < this.rowA; i++) {

                for (int j = 0; j < this.columA; j++) {

                    file.write(" " + mC[i][j]);

                }
                file.write("\n");
            }

            file.write("MatrixD: \n");

            for (int i = 0; i < this.rowB; i++) {

                for (int j = 0; j < this.columB; j++) {

                    file.write(" " + mD[i][j]);

                }
                file.write("\n");
            }

            file.close();
        }
    }*/
}
