/**
 * Processing Exercise 3b
 * Draws random colored dots at random positions
 * @author Jaosn Huang
 */

import processing.core.PApplet;

public class Main extends PApplet{

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings(){
        size(600,600, P2D);
    }

    public void setup(){
        background(203, 204, 204);
    }

    public void draw() {
        // Set Random Color
        fill(random(255), random(255), random(255));
        // Draw dot at random position
        ellipse(random(width), random(height), 25, 25);
    }

}