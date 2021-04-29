
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Esteban
 */
public class Task1 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        String fileName = "C:\\Users\\esteb\\OneDrive\\Documentos\\NetBeansProjects\\MatrixEsteban\\file.txt";
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        Matrix mA = new Matrix(4, 3);
        mA.generateMatrix(-10, 10);
        System.out.println(mA.toString());
         mA.write(fileName);
        Matrix mB = new Matrix(4, 7);
        mB.generateMatrix(-10, 10);
        System.out.println(mB.toString());

        mA.swapColumns(mB);
            System.out.println(mA.toString());
            System.out.println(mB.toString());
        

       // mA.write(fileName);
       // mB.write(fileName);
        // List columnsToChange = new ArrayList();
        //List columnsB = new ArrayList();
        //columnsB = mB.getNumbersColumns();
        //columnsToChange = mB.checkAvaibleColumns(columnsA);
        //int matrixA[][] = null;
        // mA.getMatrixA(matrixA);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

