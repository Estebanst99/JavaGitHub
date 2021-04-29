package task1;

import java.io.BufferedWriter;
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
    final char SEPARATOR = ';';

    private final int elements[][];

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
        String a;

        try {
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
        } catch (NumberOfRowsException msg) {
            a = "The rows are not the same";
        }
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

    public void writeBefore(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            
            for (int i = 0; i < elements.length; i++) {
                String line = "";
                for (int j = 0; j < elements[0].length; j++) {
                    line += elements[i][j] + SEPARATOR;                    
                }
                writer.write(line);
                line = new String();
            }
            writer.close();
        } catch (IOException ex) {
            System.err.println("IOExceptin");
        }
    }

}
