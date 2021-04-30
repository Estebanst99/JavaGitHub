package task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.Random;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Esteban
 */
public class Matrix {

    final char SEPARATOR = ' ';
    private int elements[][];

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

        int aux;

        //String a;
        //try {
        if (checkSameNumbersOfRows(m)) {

            for (int i = 0; i < elements[0].length; i++) {
                if (isElementSumColumnOdd(i)) {
                    System.out.println("La columna " + i + " es impar");
                    //check if in other matrix is this column available
                    if (isColumnAvailable(m, i)) {
                        // perform swap
                        for (int j = 0; j < elements.length; j++) {
                            aux = elements[j][i];
                            elements[j][i] = m.elements[j][i];
                            m.elements[j][i] = aux;
                        }
                    }
                }
            }
        }
        //} catch (NumberOfRowsException msg) {
        //   a = "The rows are not the same";
        //}

    }

    private boolean checkSameNumbersOfRows(Matrix m) {
        boolean res = false;
        if (elements.length == m.elements.length) {
            res = true;
        }
        return res;
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

    public void write(String fileName) throws IOException {

        Path path = Paths.get(fileName);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {

            for (int i = 0; i < elements.length; i++) {
                String line = "";
                for (int j = 0; j < elements[0].length; j++) {
                    line += elements[i][j];
                    line += SEPARATOR;
                }
                writer.write(line);
                writer.newLine();
                //line = new String();

            }
            writer.close();
        } catch (IOException ex) {
            System.err.println("IOExceptin");
        }
    }

    public void readTextFile(String fileName) {

        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            file = new File(fileName);
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String line = "";
            int count = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                //Method to store the matrix, line with the values of the row, count is a variable to know in where row we are. 
                storeMatrix(line, count);
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //Close the file anyways.
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void storeMatrix(String line, int c) {

        for (int i = 0; i < line.length(); i++) {
            
            //With the value of the count and the values of the row we store the matrix. 

            this.elements[c][i] = line.charAt(i);

        }

    }

}
