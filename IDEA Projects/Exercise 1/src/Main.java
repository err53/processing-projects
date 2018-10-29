/**
 * Processing file that draws the image presented inExercise 1
 * @author  Jason Huang
 */

import processing.core.PApplet;
public class Main extends PApplet{

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    int sX = 800;
    int sY = 600;
    public void settings(){
        size(sX, sY, P2D);
    }

    public void setup(){
        // sky
        background(119, 176, 245);
    }

    public void draw() {

        // no lines
        strokeWeight(0);

        // sun
        fill(252, 245, 0);
        arc(200, sY / 2, 100, 100, PI, 2*PI, OPEN);
        for (float i = PI; i <= 2*PI ; i+= PI / 10 - 0.003) {
            arc(200, sY/2, 160, 160, i, i + PI/90);
        }
        // ground
        fill(28, 234, 92);
        rect(0, sY/2, sX, sY);


        // border
        strokeWeight(1);
        // dat line
        fill(0);
        line(0, sY/2, sX, sY/2);

        // house box
        fill(240, 97, 123);
        rectMode(CENTER);
        rect(600, sY/2, 165, 100);

        // roof
        fill(0);
        triangle(600, sY/2 - 100,
                510, sY/2 - 50,
                690, sY/2 - 50);

        // door
        fill(255);
        rect(600, sY/2, 35, 65);

        // doorknob
        fill(0);
        strokeWeight(7);
        point(587, sY/2 + 2);
    }

}