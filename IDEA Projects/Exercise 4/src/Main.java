/**
 * Processing Exercise 4
 * Draw overlapping circles by incrementing variables by specific values
 */

import processing.core.PApplet;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    float[] c1 = {0, 0, 15};
    float[] c2 = {0, 0, 100};

    public void settings() {
        size(300, 600, P2D);
    }

    public void setup() {
        background(255);
        c2[0] = width / 2;
        c2[1] = height;
    }

    public void draw() {
        // Draw ellipse 1
        ellipse(c1[0], c1[1], c1[2], c1[2]);
        // Draw ellipse 2
        ellipse(c2[0], c2[1], c2[2], c2[2]);

        // Increment values of ellipse 1
        c1[0]++;
        c1[1] += 1.5;
        c1[2] += 0.1;

        // Increment values of ellipse 2
        c2[0] += 0.66;
        c2[1] -= 10;
        c2[2] -= 1.5;
    }
}