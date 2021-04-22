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
public class Matrix {

    //comment from bazantm
    private int elements[][];
    private int columns;

    public Matrix(int rows, int colums) {

        this.elements = new int[rows][colums];

    }

    private int generateRandomElements(int a, int b) {

        Random rd = new Random();
        return a + rd.nextInt(b - a + 1);
    }

    public void generateMatrix(int a, int b) {

        for (int i = 0; i < elements.length; i++) {

            for (int j = 0; j < elements[0].length; j++) {

                this.elements[i][j] = generateRandomElements(a, b);
            }
        }
    }

    private int getSumOfColumn(int columnIndex) {
        int sum = 0;

        for (int i = 0; i < elements.length; i++) {
            sum += elements[i][columnIndex];
        }

        return sum;
    }

    private boolean isElementSumColumnOdd(int columnIndex) {
        boolean result = false;

        int sum = getSumOfColumn(columnIndex);

        if (sum % 2 == 1) {
            result = true;
        }
        return result;
    }

    public void swapColumns(Matrix m) {
        for (int i = 0; i < elements[0].length; i++) {
            if (isElementSumColumnOdd(i)) {
                //check if in other matrix is this column available
                if (isColumnAvailable(m, i)) {
                    // perform swap
                    
                }
                
            }
            
        }
    }
    
    
    private List<Number> checkColumnOdd() {

        List<Number> valuesOfColumns = new ArrayList<>();
        for (int i = 0; i < elements[0].length; i++) {
            if (isElementSumColumnOdd(i)) {
                for (int j = 0; j < elements.length; j++) {
                    int[] element = elements[j];
                    
                }
                
            }
        }
        return valuesOfColumns;
    }

    private boolean isColumnAvailable(Matrix matrix, int index) {
        boolean result = false;

        try {
            int value = matrix.elements[0][index];
            result = true;
        } catch (ArrayIndexOutOfBoundsException ex) {

        }

        return result;
    }

    private List<Number> checkAvaibleColumns(List a) {

        List<Number> columnsToChange = new ArrayList<>();

        if (a.size() >= elements[0].length) {
            for (int i = 0; i < elements[0].length; i++) {
                for (int j = 0; j < a.size(); j++) {
                    if (a.get(j).equals(i)) {
                        columnsToChange.add(i);
                    }
                }
            }
        } else {
            for (int i = 0; i < a.size(); i++) {
                for (int j = 0; j < elements[0].length; j++) {
                    if (a.get(i).equals(j)) {
                        columnsToChange.add(i);
                    }
                }
            }
        }
        return columnsToChange;
    }

    public int[][] getMatrixA() {
        int[][] copyOfElements = new int[elements.length][elements[0].length];
        for (int i = 0; i < elements.length; i++) {

            for (int j = 0; j < elements[0].length; j++) {

                copyOfElements[i][j] = elements[i][j];
            }
        }

        return copyOfElements;
    }

    List getNumbersColumns() {

        List numberOfColumns = new ArrayList();
        for (int i = 0; i < columns; i++) {
            numberOfColumns.add(i);
        }
        return numberOfColumns;
    }

    /*  public void checkAvaibleColumn(int nCol) {

        for (int i = 0; i < elements[0].length; i++) {
            if (i <= nCol) {
                if (isElementSumColumnOdd(i)) {
                    System.out.println("Column " + i + " has to be changed in both matrix");
                }
            }

             if (isElementSumColumnOdd(i)) {
                System.out.println("Column " + i + " has to be changed");
            }
        }
    }*/
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[0].length; j++) {
                sb.append(String.format("%6d", elements[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
/*
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
// }
/*
    public void swapColumn() throws NumberOfRowsException {
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
 /*                 this.mC[i][j] = this.mB[i][j];
                    } else {
                        /* aux = this.elements[i][j];
                    this.mC[i][j] = aux;*/
 /*         this.mC[i][j] = this.elements[i][j];
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
 /*          this.mD[i][j] = this.elements[i][j];
                    } else {
                        /* aux = this.elements[i][j];
                    this.mC[i][j] = aux;*/
 /*             this.mD[i][j] = this.mB[i][j];
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
    }*/

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
//}
