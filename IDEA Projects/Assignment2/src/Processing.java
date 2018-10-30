import processing.core.PApplet;

public class Processing extends PApplet {
    float x, y;

    public static void main(String[] args) {
        PApplet.main("Processing");
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        background(255);

        smooth();
        noStroke();

//        triangleSier(0, 700, 400, 0, 800, 700, 10);
    }

    public void draw() {
//        if ((x != mouseX || y != mouseY ) && mouseX < width) {
//            background(255);
//            smooth();
//            noStroke();
//            x = mouseX; y = mouseY;
//
//            triangleSier(0, 700, 400, 0, 800, 700, (int) (x / width * 11) );
//            System.out.println((int)(x / width * 11));
//        }

        drawLine(0, height / 2, width, height / 2, 2, false);
    }

    void triangleSier(float x1, float y1, float x2, float y2, float x3, float y3, int n) {
        // 'n' is the number of iteration.
        if (n > 0) {
            fill(255 - 255 / n, 255 - 255 / n, 255 - 255 / n);
            triangle(x1, y1, x2, y2, x3, y3);

            // Calculating the midpoints of all segments.
            float h1 = (float) ((x1 + x2) / 2.0);
            float w1 = (float) ((y1 + y2) / 2.0);
            float h2 = (float) ((x2 + x3) / 2.0);
            float w2 = (float) ((y2 + y3) / 2.0);
            float h3 = (float) ((x3 + x1) / 2.0);
            float w3 = (float) ((y3 + y1) / 2.0);

            // Trace the triangle with the new coordinates.
            triangleSier(x1, y1, h1, w1, h3, w3, n - 1);
            triangleSier(h1, w1, x2, y2, h2, w2, n - 1);
            triangleSier(h3, w3, h2, w2, x3, y3, n - 1);
        }
    }

    // fixme
    void drawLine(float x1, float y1, float x2, float y2, int n, boolean isWhite) {
        strokeWeight(5);

        if (isWhite) {
            stroke(255);
            line(x1, y1, x2, y2);
            return;
        }

        if (n > 0) {
            float xa = (float) (x1 + (x2 - x1) * 0.33);
            float ya = (float) (y1 + (y2 - y1) * 0.33);
            float xb = (float) (x1 + (y2 - y1) * 0.66);
            float yb = (float) (y1 + (y2 - y1) * 0.66);

            drawLine(x1, y1, xa, ya, n - 1, false);
            drawLine(xa, ya, xb, yb, n - 1, true);
            drawLine(xb, yb, x2, y2, n - 1, false);

        } else {
            stroke(0);
            line(x1, y1, x2, y2);
        }
    }

}