/**
 * Processing Exercise 3a
 * A simple program that draws circles
 * @author  Jason Huang
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
        // Set background color to a specific shade of grey used in the image
        background(204, 203, 203);
        // Set fill of elipse to white
        fill(255);
    }

    public void draw() {
        // Draw elipse at mouse location each frame
        ellipse(mouseX, mouseY, 50, 50);
    }
}