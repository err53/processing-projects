/**
 * Processing Exercise 2
 * Draw arcs and dots using elipse and arc
 * @author Jason Huang
 */

import processing.core.PApplet;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    int s = 800;

    public void settings() {
        size(s, s, P2D);
    }

    public void setup() {

    }

    public void draw() {
        background(255);

        // Reset All
        strokeWeight(0);
        fill(255);
        stroke(255);
        noFill();
        noStroke();

        // Yellow
        strokeWeight(27);
        stroke(215, 250, 53);
        arc(width / 2, height / 2 + 180, 2 * width / 3 - 80, 2 * height / 3 - 10,
                PI - radians((float) 9.5), 2 * PI - radians(25));
        strokeWeight(5);
        ellipse(width / 2, height / 2 + 180, 5, 5);

        // Blue
        strokeWeight(10);
        stroke(60, 150, 250);
        arc(width / 2, height / 2 + 142, 2 * width / 3 - 70, 2 * height / 3 - 0,
                PI + radians(10), 2 * PI - radians(15));
        strokeWeight(5);
        ellipse(width / 2, height / 2 + 142, 5, 5);

        // Green
        strokeWeight(25);
        stroke(250, 53, 53);
        arc(width / 2, height / 2 + 105, 2 * width / 3 - 20, 2 * height / 3, PI, 2 * PI);
        strokeWeight(5);
        ellipse(width / 2, height / 2 + 105, 5, 5);

        // Red
        strokeWeight(13);
        stroke(53, 250, 123);
        arc(width / 2, height / 2 + 100, 2 * width / 3, 2 * height / 3,
                PI - radians(30), 2 * PI + radians(10));
        strokeWeight(5);
        ellipse(width / 2, height / 2 + 100, 5, 5);

        // Purple
        strokeWeight(6);
        stroke(192, 53, 250);
        arc(width / 2, height / 2 + 120, 2 * width / 3, 2 * height / 3,
                PI - radians(10), 2 * PI + radians(20));
        strokeWeight(5);
        ellipse(width / 2, height / 2 + 120, 5, 5);
    }

}