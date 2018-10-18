import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

/**
 * Functional radar that is interactive and uses {@link processing.core.PApplet#rect(float, float, float, float)},
 * {@link processing.core.PApplet#arc(float, float, float, float, float, float)},
 * {@link processing.core.PApplet#ellipse(float, float, float, float)}, and
 * {@link processing.core.PApplet#point(float, float)}. Custom Point class was created to easily make and remove radar
 * points. Radar checks for mouse position every 30 frames, updating the line coordinates with {@link Main#circlePoint()},
 * and checking with {@link Main#pointLies()}. The condition of the points are also updated with {@link Main#updatePoints()},
 * and an alert is drawn with {@link Main#drawAlert()} every time a point is created.
 *
 * @author Jason Huang
 * @see processing.core.PApplet
 * @see Point
 */
public class Main extends PApplet {

    float arcStart = 0, arcX, arcY; // Start position of arc (in degrees), point of arc on outside circle
                                    // arcX and arcY are dependent on the position of arcStart and will be updated
                                    // when needed

    int colorR = 0, colorG = 255, colorB = 0; // Set color scheme of radar


    ArrayList<Point> points = new ArrayList<>(); // List of drawn points

    int frameCounter = 30;  // Count elapsed frames

    int alertBrightness = 0; // Brightness of PING! alert;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public void settings() {
        size(600, 600, P3D); // Set size of window;
    }

    public void draw() {
        // Reset environment
        noStroke();
        noFill();
        background(0);


        /* Draw Message */


        /* Draw Arcs */

        // Draw First arc
        noStroke();
        fill(colorR, colorG, colorB, 221);
        arc(width / 2, height / 2, 280, 280, radians(arcStart - 5), radians(arcStart));

        // Draw Second Arc
        fill(colorR, colorG, colorB, 160);
        arc(width / 2, height / 2, 280, 280, radians(arcStart - 10), radians(arcStart - 5));

        // Draw Third Arc
        fill(colorR, colorG, colorB, 119);
        arc(width / 2, height / 2, 280, 280, radians(arcStart - 50), radians(arcStart - 10));

        // Draw Fourth Arc
        fill(colorR, colorG, colorB, 61);
        arc(width / 2, height / 2, 280, 280, radians(arcStart - 160), radians(arcStart - 50));


        /* Draw Lines */

        // Set up properties of lines
        noFill();
        strokeWeight(1);
        stroke(colorR, colorG, colorB, 209);

        // Diagonal Line from top left to bottom right
        line(width / 2 - 75 * sqrt(2), height / 2 - 75 * sqrt(2),
                width / 2 + 75 * sqrt(2), height / 2 + 75 * sqrt(2));
        // Diagonal line from bottom left to top right
        line(width / 2 - 75 * sqrt(2), height / 2 + 75 * sqrt(2),
                width / 2 + 75 * sqrt(2), height / 2 - 75 * sqrt(2));

        // Horisontal line across the middle
        line(width / 2 - 150, height / 2, width / 2 + 150, height / 2);
        // Vertical line accross the middle
        line(width / 2, height / 2 - 150, width / 2, height / 2 + 150);

        // Draw first outer circle
        ellipse(width / 2, height / 2, 300, 300);

        // Draw second outer circle
        ellipse(width / 2, height / 2, 280, 280);

        // Draw first inner circle
        ellipse(width / 2, height / 2, 200, 200);

        // Draw second inner circle
        ellipse(width / 2, height / 2, 100, 100);


        // Draw alert
        drawAlert();

        /* Create, Draw, and Animate Points */
        updatePoints();


        /* Animate arc  */
        arcStart++; // Increment Arc Position by 1 degree every frame


        // Randomize color on mouse press
        if (mousePressed) {
            colorR = (int) random(255);
            colorG = (int) random(255);
            colorB = (int) random(255);
        }


    }

    /**
     * Function that generates alert with text "PING!"
     *
     * @author Jason Huang
     * @see Main
     */
    public void drawAlert() {

        fill(colorR, colorG, colorB, alertBrightness);
        textAlign(CENTER, CENTER);
        textSize(50);
        text("PING!", width / 2, height / 2 + 200);

        noFill();
        stroke(colorR, colorG, colorB, alertBrightness);
        strokeWeight(5);
        rectMode(CENTER);
        rect(width / 2, height / 2 + 205, 140, 60);

        if (alertBrightness > 0) {
            alertBrightness -= 5;
        }
    }

    /**
     * Function to create, draw, and animate point (runs every frame)
     *
     * @author Jason Huang
     * @see Main
     */
    public void updatePoints() {
        // Create a point every 30 frames
        if (frameCounter >= 30) {
            // Update position of line on circle
            circlePoint();

            if (pointLies()) {  // If point lies on the first part of the arc
                // Add new points dynamically to Array List of points
                points.add(new Point(mouseX, mouseY, 255, 10));
                alertBrightness = 255;

                // Reset frame counter
                frameCounter = 0;
            }
        } else {
            // Increment frame counter
            frameCounter++;
        }

        // Draw and update points if there are any
        if (points != null && !points.isEmpty()) {

            // Iterate through points
            for (int i = 0; i < points.size(); i++) {

                /* Draw points */

                // Set point color with color scheme and appropriate brightness
                stroke(colorR, colorG, colorB, points.get(i).getBrightness());
                // Set appropriate size of point
                strokeWeight(points.get(i).getSize());

                // Draw point
                point(points.get(i).getX(), points.get(i).getY());


                /* Animate Point brightness and size */

                // If brightness is above zero
                if (points.get(i).getBrightness() > 0) {
                    // Decrease brightness
                    points.get(i).setBrightness(points.get(i).getBrightness() - 1);
                }

                // If size is greater than zero
                if (points.get(i).getSize() > 0) {
                    // Decrease size
                    points.get(i).setSize((float) (points.get(i).getSize() - 0.025));
                }
                // If size is less than or equal to zero
                else {
                    // Remove point
                    points.remove(i);
                }
            }
        }
    }

    /**
     * Function that updates coordinate point of arc on circle
     *
     * @author Jason Huang
     * @see Main
     */
    public void circlePoint() {
        arcX = width / 2 + (140 * cos(radians(arcStart)));
        arcY = height / 2 + (140 * sin(radians(arcStart)));
    }

    /**
     * Determine if mouse is along the front of the arc
     *
     * @author Jason Huang
     * @see Main
     * @return If the mouse lies between the centre of the circle and the edge of the arc
     */
    public boolean pointLies() {

        // Get distance of mouse from centre
        float distanceXFromCenter = mouseX - width / 2;
        float distanceYFromCenter = mouseY - height / 2;

        // Get distance of arc Point from centre
        float distanceXFromArcPoint = arcX - width / 2;
        float distanceYFromArcPoint = arcY - width / 2;

        // Get cross value of point to determine distance of mouse from Euclidean line passing through the arc and the
        // centre (distance is squared)
        float cross = distanceXFromCenter * distanceYFromArcPoint - distanceYFromCenter * distanceXFromArcPoint;

        // Print absolute cross distance (for debugging reasons)
        System.out.println(abs(cross));

        double threshold = 1000; // Set threshold of intersection (distance is squared)
        if (abs(cross) > threshold) return false; // Check if mouse is along same line as the radar, return false if not

        // If the absolute x distance is greater than or equal to the y distance
        if (abs(distanceXFromArcPoint) >= abs(distanceYFromArcPoint)) {
            // Return if the x value of the mouse position is between the x value of the centre and the x value of the
            // point on the circle
            return distanceXFromArcPoint > 0 ?
                    width / 2 <= mouseX && mouseX <= arcX :
                    arcX <= mouseX && mouseX <= width / 2;
        }
        // If the absolute x distance is less than the y distance
        else {
            // Return if the y value of the mouse position is etween the y value of the centre and the y value of the
            // point on the circle
            return distanceYFromArcPoint > 0 ?
                    height / 2 <= mouseY && mouseY <= arcY :
                    arcY <= mouseY && mouseY <= height / 2;
        }
    }
}