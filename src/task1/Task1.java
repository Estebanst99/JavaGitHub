
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task1;

import java.awt.event.MouseEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Esteban
 */
public class Task1 extends Application {

    private TextArea textArea, textArea2, textArea3;

    @Override
    public void start(Stage stage) throws Exception {
        //String fileName = "file.txt";

        BorderPane root = new BorderPane();
        //StackPane root2 = new StackPane();
        //Scene scene = new Scene(root);
        //Scene scene2 = new Scene(root2);

        Matrix mA = new Matrix(4, 3);
        mA.generateMatrix(-10, 10);

        Matrix mB = new Matrix(4, 7);
        mB.generateMatrix(-10, 10);

        String text = "Matrix A:\n" + mA.toString() + "\n";
        text = text + "Matrix B:\n" + mB.toString();
        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.appendText(text);

        Button bt = new Button("Press to execute : SwapColumnsMethod");
        //bt.setDefaultButton(true);
        bt.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {

                boolean b = false;
                
                mA.swapColumns(mB);
                b = mA.getCheckSwap();

                if (b == true) {

                    String text2 = "Matrix A (after changing):\n" + mA.toString() + "\n";
                    text2 = text2 + "Matrix B (after changing):\n" + mB.toString();

                    textArea2 = new TextArea();
                    textArea2.setEditable(false);
                    textArea2.appendText(text2);
                    root.setRight(textArea2);
                    
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                } else {

                    textArea3 = new TextArea();
                    String text3 = "Couldn´t do the operation";
                    textArea3.setEditable(false);
                    textArea3.appendText(text3);
                    root.setRight(textArea3);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }

        });

        // root.getChildren().add(bt);
        root.setLeft(textArea);
        root.setCenter(bt);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        mA.write("MartrixA-before.txt");
        //System.out.println(mB.toString());
        mB.write("MartrixB-before.txt");

        System.out.println(mA.toString());
        System.out.println(mB.toString());
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
