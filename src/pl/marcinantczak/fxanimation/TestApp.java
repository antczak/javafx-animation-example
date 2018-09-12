/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinantczak.fxanimation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Marcin
 */
public class TestApp extends Application {
    
    public static int stageWidth = 0;
    public static int stageHeight = 0;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
        stageWidth = (int) stage.getWidth();
        stageHeight = (int) stage.getHeight();
        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            stageWidth = newVal.intValue();
        });
        stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            stageHeight = newVal.intValue();
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
