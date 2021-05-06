
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Esteban
 */
public class Task1 extends Application {
    private TextArea textArea;

    @Override
    public void start(Stage stage) throws Exception {
        //String fileName = "file.txt";
        
        Matrix mA = new Matrix(4, 3);
        mA.generateMatrix(-10, 10);
        
        BorderPane root = new BorderPane();
        
        textArea = new TextArea();
        textArea.setEditable(false);
        
        textArea.appendText("Matrix A:\n" + mA.toString());
        
        
        root.setCenter(textArea);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        
        mA.write("MartrixA-before.txt");
        Matrix mB = new Matrix(4, 7);
        mB.generateMatrix(-10, 10);
        //System.out.println(mB.toString());
        mB.write("MartrixB-before.txt");

        mA.swapColumns(mB);
        //System.out.println(mA.toString());
        //System.out.println(mB.toString());

        mA.write("MartrixA-after.txt");
        mB.write("MartrixB-after.txt");

        mA.readTextFile("MartrixA-after.txt");
        mB.readTextFile("MartrixB-after.txt");
        //System.out.println(mA.toString());
        //System.out.println(mB.toString());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
