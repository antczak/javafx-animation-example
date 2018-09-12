/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinantczak.fxanimation;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author Marcin
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Canvas canvas;
    @FXML
    private StackPane stackPane; 
    private AnimationTimer timer; 
    private ArrayList<Sprite> sprites;
    private int frames = 0;
    private int fps = 0;
    private long startTime = 0;
    private long lastTime = 0;
    private long counter;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Random rand = new Random();
        sprites = new ArrayList<>();
        startTime = System.nanoTime();
        timer = new AnimationTimer(){
            @Override
            public void handle(long now) {
                long totalElapsed = System.nanoTime() - startTime;
                long elapsed = totalElapsed - lastTime;
                lastTime = totalElapsed;
                counter += elapsed;
                frames++;
                canvas.setWidth(stackPane.getWidth());
                canvas.setHeight(stackPane.getHeight());
                GraphicsContext g = canvas.getGraphicsContext2D();
                g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                for (Sprite sprite: sprites) {
                    sprite.render(g);
                }
                sprites.add(new Sprite(rand.nextInt((int)canvas.getWidth()), rand.nextInt((int)canvas.getHeight())));
                g.setFill(Color.BLACK);
                g.fillRect(10, 20, 35, 35);
                g.setFill(Color.GREEN);
                g.fillText(fps+"", 15, 45);
            }
        };
        timer.start();
    }  
    
    
    
}
