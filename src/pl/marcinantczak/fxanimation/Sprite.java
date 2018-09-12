/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.marcinantczak.fxanimation;

import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Marcin
 */
public class Sprite {
    private int y;
    private int x;
    private int dy;
    private int dx;
    private Random rand;
    private Color color;
    public Sprite(int x, int y) {
        this.rand = new Random();
        this.x = x;
        this.y = y;
        this.generateDestination();
    }
    
    private void generateDestination() {
        this.dx = rand.nextInt(TestApp.stageWidth);
        this.dy = rand.nextInt(TestApp.stageHeight);
        this.color = Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
    }
    
    public void render(GraphicsContext g) {
        if (this.x > this.dx) this.x--;
        else if (this.x < this.dx) this.x++; 
        
        if (this.y > this.dy) this.y--;
        else if (this.y < this.dy) this.y++; 
        
        if (this.x == this.dx && this.y == this.dy) {
            this.generateDestination();
        }
            
        g.setFill(color);
        g.fillOval(x, y, 20, 20);
    }
}
