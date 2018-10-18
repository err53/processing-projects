import processing.core.PApplet;

public class Main extends PApplet {
    float bx = 0, by = 0, bs = 30;

    float wx = 0, wy = 600, ws = 50;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings(){
        size(350,600, P2D);
    }

    public void setup(){
        background(255);
        frameRate(120);
    }

    public void draw() {
        // Reset Stuff
        noStroke();
        noFill();

        // Draw black circles
        stroke(255);
        strokeWeight(1);
        fill(0);
        ellipse(bx, by, bs, bs);

        // Draw white circles
        stroke(0);
        strokeWeight(1);
        fill(255);
        ellipse(wx, wy, ws, ws);

        // Increment black circle position and size
        bx += 2; by +=2; bs += 0.15;

        // Increment white circle position and size
        wx += 1; wy -= 10; ws -= 0.8;

        // Wrap black circle position around
        if (bx > width) {
            bx = 0;
            bs = 30;
        }
        if (by > height / 2) {
            by = 0;
            bs = 30;
        }
        
        // Wrap white circle position around
        if (wx > width) {
            wx = 0;
            ws = 50;
        }
        if (wy < height / 2) {
            wy = height;
            ws = 50;
        }

        // Draw middle line
        stroke(35,205,133);
        strokeWeight(5);
        line(0, height / 2, width, height / 2);
    }
}