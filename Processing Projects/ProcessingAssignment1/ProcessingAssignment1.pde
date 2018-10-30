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

float arcStart = 0, arcX, arcY; // Start position of arc (in degrees), point of arc on outside circle
// arcX and arcY are dependent on the position of arcStart and will be updated
// when needed

int colorR = 0, colorG = 255, colorB = 0; // Set color scheme of radar


ArrayList<Point> points = new ArrayList<Point>(); // List of drawn points

int frameCounter = 30;  // Count elapsed frames

int alertBrightness = 0; // Brightness of PING! alert;

public void settings() {
  size(600, 600, P2D); // Set size of window;
}

public void setup() {
  smooth();
}

public void draw() {
  // Reset environment
  noStroke();
  noFill();
  background(0);


  /* Draw Arcs */

  //        // Draw First arc
  //        noStroke();
  //        fill(colorR, colorG, colorB, 221);
  //        arc(width / 2, height / 2, 280, 280, radians(arcStart - 5), radians(arcStart));
  //
  //        // Draw Second Arc
  //        fill(colorR, colorG, colorB, 160);
  //        arc(width / 2, height / 2, 280, 280, radians(arcStart - 10), radians(arcStart - 5));
  //
  //        // Draw Third Arc
  //        fill(colorR, colorG, colorB, 119);
  //        arc(width / 2, height / 2, 280, 280, radians(arcStart - 50), radians(arcStart - 10));
  //
  //        // Draw Fourth Arc
  //        fill(colorR, colorG, colorB, 61);
  //        arc(width / 2, height / 2, 280, 280, radians(arcStart - 160), radians(arcStart - 50));

  noStroke();
  for (int i = 0; i <= 200; i++) {
    fill(colorR, colorG, colorB, 200 - i);
    arc(width / 2, height / 2, 280, 280, radians(arcStart - i - 1), radians(arcStart - i));
  }

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

  // Draw Cross
  drawCross();

  // Draw UI
  drawUI();


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
 * Function that draws the crosshair
 * 
 * @author Jason Huang
 * @see Main
 */
public void drawCross() {
  strokeWeight(2);
  stroke(colorR, colorG, colorB);
  line(mouseX, mouseY, mouseX, mouseY + 10); // draw line up
  line(mouseX, mouseY, mouseX, mouseY - 10); // draw line down
  line(mouseX, mouseY, mouseX + 10, mouseY); // draw line right
  line(mouseX, mouseY, mouseX - 10, mouseY); // draw line left
}

/**
 * Function that draws the rectangles and UI
 *
 * @author Jason Huang
 * @see Main
 */
public void drawUI() {
  rectMode(CORNERS);
  rect(25, 25, width / 2 - 25, 100);
  rect(width / 2 + 25, 25, width - 25, 100);
  rect(25, height - 25, width / 2 - 100, height - 100);
  rect(width / 2 + 100, height - 25, width - 25, height - 100);

  fill(colorR, colorG, colorB);
  textSize(25);
  text("mouseScanner.exe", width * 0.25, (100 - 25) / 2 + 5);
  text("ACTIVATED", width * 0.25, (100 - 25) / 2 + 40);

  text("COORDINATES:", width * 0.75, (100 - 25) / 2 + 5);
  text('(' + String.valueOf(mouseX -  width / 2) + ", " + String.valueOf(height / 2 - mouseY) + ')', width * 0.75, (100 - 25) / 2 + 40);

  text("Arc Pos:", width * 0.19, height - (100 - 25) / 2 - 45);
  text('(' + String.valueOf((int) arcX - width / 2) + ", " + String.valueOf(height / 2 - (int)arcY) + ')', width * 0.19, height - (100 - 25) / 2 - 5);
  
  text("Uptime:", width * 0.82, height - (100 - 25) / 2 - 45);
  text(String.valueOf((int) millis() / 1000) + " seconds", width * 0.82, height - (100 - 25) / 2 - 5);
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
  // Update position of line on circle
  circlePoint();

  // Create a point every 30 frames
  if (frameCounter >= 30) {
    if (pointLies(width / 2, height / 2, arcX, arcY, mouseX, mouseY)) {  // If point lies on the first part of the arc
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

      print(points.get(i).getSize());

      /* Draw points */

      // Set point color with color scheme and appropriate brightness
      stroke(colorR, colorG, colorB, points.get(i).getBrightness());
      // Set appropriate size of point
      strokeWeight(points.get(i).getSize());

      // Draw point
      point(points.get(i).getX(), points.get(i).getY());


      /* Animate Point brightness and size */

      // If brightness is above zero
      if (points.get(i).getBrightness() >= 1) {
        // Decrease brightness
        points.get(i).setBrightness(points.get(i).getBrightness() - 1);
      }

      // If size is greater than zero
      if (points.get(i).getSize() >= 0.025) {
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
public boolean pointLies(float Ax, float Ay, float Bx, float By, float Px, float Py) {

  if (abs(sqrt(sq(Ax-Px) + sq(Ay-Py)) + 
    sqrt(sq(Px - Bx) + sq(Py - By)) - 
    sqrt(sq(Ax-Bx) + sq(Ay-By))) 
    <= 1) {    // If the difference between the line from A to B passing through coordinates P is and the line directly from A to B is within 1 pixel, return true
    return true;
  }

  // Else, return false
  return false;
}

/**
 * Custom point class that contains the coordinates, brightness, and size of the point
 *
 * @author Jason Huang
 * @see Main
 */
public class Point {
  private float x, y, brightness, size;

  /**
   * Point Constructor
   *
   * @param x             x-coordinate of the point
   * @param y             y-coordinate of the point
   * @param brightness    brightness of the point
   * @param size          size of the point
   *
   * @author Jason Huang
   * @see Main
   */
  public Point(float x, float y, float brightness, float size) {

    // Assign values for position
    this.x = x;
    this.y = y;
    this.brightness = brightness;
    this.size = size;
  }

  // Getter and Setter functions

  // There are no setter functions for X and Y, as the coordinates of a point should be immutable

  /**
   * Get X-value
   * @return X-value of point
   */
  public float getX() {
    return x;
  }

  /**
   * Get Y-value
   * @return Y-value of point
   */
  public float getY() {
    return y;
  }

  // The brightness and the size change throughout the point's life, so we can modify them through setter functions

  /**
   * Get Brightness
   * @return Brightness of point
   */
  public float getBrightness() {
    return brightness;
  }

  /**
   * Set Brightness
   * @param brightness Brightness of point
   */
  public void setBrightness(float brightness) {
    this.brightness = brightness;
  }

  /**
   * Get Size
   * @return Size of point
   */
  public float getSize() {
    return size;
  }

  /**
   * Set Size
   * @param size Size of point
   */
  public void setSize(float size) {
    this.size = size;
  }
}
