import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Processing extends PApplet {

/*
 * Drug Trip Simulation
 */

int s = 1000;

public void settings() {
  
  size(s, s);
  int colors = 255;
}

public void setup() {
}

public void draw() {
  background(0);
  
  if (mousePressed) {   // Have a Seizure
    fill(random(0, 255), random(0, 255), random(0, 255));
    ellipse(random(0, s), random(0, s), random(0, s), random(0, s));
    fill(random(0, 255), random(0, 255), random(0, 255));
    rect(random(0, s), random(0, s), random(0, s), random(0, s));
    fill(random(0, 255), random(0, 255), random(0, 255));
    ellipse(random(0, s), random(0, s), random(0, s), random(0, s));
    fill(random(0, 255), random(0, 255), random(0, 255));
    rect(random(0, s), random(0, s), random(0, s), random(0, s));
    fill(random(0, 255), random(0, 255), random(0, 255));
    ellipse(random(0, s), random(0, s), random(0, s), random(0, s));
    fill(random(0, 255), random(0, 255), random(0, 255));
    rect(random(0, s), random(0, s), random(0, s), random(0, s));
    fill(random(0, 255), random(0, 255), random(0, 255));
    ellipse(random(0, s), random(0, s), random(0, s), random(0, s));
    fill(random(0, 255), random(0, 255), random(0, 255));
    rect(random(0, s), random(0, s), random(0, s), random(0, s));
    fill(random(0, 255), random(0, 255), random(0, 255));
    ellipse(random(0, s), random(0, s), random(0, s), random(0, s));
    fill(random(0, 255), random(0, 255), random(0, 255));
    rect(random(0, s), random(0, s), random(0, s), random(0, s));
    fill(random(0, 255), random(0, 255), random(0, 255));
    ellipse(random(0, s), random(0, s), random(0, s), random(0, s));
    fill(random(0, 255), random(0, 255), random(0, 255));
    rect(random(0, s), random(0, s), random(0, s), random(0, s));
    fill(random(0, 255), random(0, 255), random(0, 255));
    ellipse(random(0, s), random(0, s), random(0, s), random(0, s));
    fill(random(0, 255), random(0, 255), random(0, 255));
    rect(random(0, s), random(0, s), random(0, s), random(0, s));
    fill(random(0, 255), random(0, 255), random(0, 255));
    ellipse(random(0, s), random(0, s), random(0, s), random(0, s));
    fill(random(0, 255), random(0, 255), random(0, 255));
    rect(random(0, s), random(0, s), random(0, s), random(0, s));
  }
    
  
  
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Processing" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
