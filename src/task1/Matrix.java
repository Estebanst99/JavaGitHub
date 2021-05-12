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
    private boolean b = false;

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
        boolean b = false; 

        //String a;
        //try {
        if (checkSameNumbersOfRows(m)) {

            for (int i = 0; i < elements[0].length; i++) {
                if (isElementSumColumnOdd(i)) {
                    System.out.println("The column " + i + " is odd");
                    //check if in other matrix is this column available
                    if (isColumnAvailable(m, i)) {
                        // perform swap
                        for (int j = 0; j < elements.length; j++) {
                            aux = elements[j][i];
                            elements[j][i] = m.elements[j][i];
                            m.elements[j][i] = aux;
                        }
                        b = true; 
                        swapMethodBoolean(b);
                    }
                }
            }
        }
        //} catch (NumberOfRowsException msg) {
        //   a = "The rows are not the same";
        //}

    }
    
    public void swapMethodBoolean (boolean b){
        
        
        this.b = b ; 
    }
    
    public boolean getCheckSwap(){    
    
        return this.b;
    
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

    public static Matrix readTextFile(String fileName) {

        Matrix m = null;
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            file = new File(fileName);
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String line = null;
            int rows = 0;
            int columns = 0;

            while ((line = br.readLine()) != null) {

                String[] values = line.split(" ");
                columns = values.length;
                rows++;
            }

            br = new BufferedReader(fr);

            m = new Matrix(rows, columns);
            if ((line = br.readLine()) != null) {
                for (int i = 0; i < rows; i++) {
                    line = br.readLine();
                    String[] values = line.split(" ");
                    for (int j = 0; j < columns; j++) {
                        m.elements[i][j] = Integer.parseInt(values[j].trim());
                    }
                }
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
        return m;
    }
}
