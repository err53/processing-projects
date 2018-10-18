import processing.core.PApplet;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings(){
        size(600,600);
    }

    public void setup(){
        background(255);
        noStroke();
    }

    public void draw() {
        background(255);
        int x = 5, y = 5;
        while (x <= mouseX) {
            while (y <= mouseY) {
                fill(255,0,255, 255 - (x - 5) * (y - 5) % 255);
                ellipse(x + 5, y + 5, 10, 10);
                y += 10;
            }
            y = 5;
            x += 10;
        }
    }
}