import processing.core.PApplet;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings() {
        size(400, 400);
    }

    public void setup() {
        frameRate(240);
    }

    int XValue = 200;
    int YValue = 200;
    int OXValue = 200;
    int OYValue = 200;
    boolean right = true;
    boolean up = true;
    boolean end = false;

    public void draw() {
        if (end == false) {
            background(0);
            fill(255);
            noStroke();
            rect(385, -1, 20, 401);
            //Rectangle
            fill(0);
            rect(10, 0, 15, 400);
            fill(255);
            /*if (mouseY >= 325) {
                rect(10, 325, 15, 75);
            } else {
                */rect(10, mouseY, 15, 75);/*
            }*/
            //Circle
            fill(0);
            ellipse(OXValue, OYValue, 20, 20);
            fill(255);
            ellipse(XValue, YValue, 20, 20);
            if (XValue <= 35 && (mouseY + 75) - YValue >= 0 && (mouseY + 75) - YValue <= 75 || XValue >= 375) {
                right = !right;
            } else if (XValue <= 25) {
                end = true;
            }

            if (YValue <= 10 || YValue >= 390) {
                up = !up;
            }
            if (right) {
                if (up) {
                    OXValue = XValue;
                    OYValue = YValue;
                    XValue++;
                    YValue = YValue - 1;
                } else {
                    OXValue = XValue;
                    OYValue = YValue;
                    XValue++;
                    YValue++;
                }
            } else {
                if (up) {
                    OXValue = XValue;
                    OYValue = YValue;
                    XValue = XValue - 1;
                    YValue = YValue - 1;
                } else {
                    OXValue = XValue;
                    OYValue = YValue;
                    XValue = XValue - 1;
                    YValue++;
                }
            }
        } else {
            background(0);
            System.out.println("GOOD GAME");
        }
    }

}