/*
 * Drug Trip Simulation
 */

int s = 1000;

void settings() {
  
  size(s, s);
  int colors = 255;
}

void setup() {
}

void draw() {
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