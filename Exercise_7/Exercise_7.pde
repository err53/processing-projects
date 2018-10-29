void settings() {
  size(320, 640);
}

void draw() {
  background(255);
  stroke(1);
  for (int i = 0; i < height / 2; i += 20) {
    for (int j = 0; j < width; j += 20) {
      fill (0, 255 - i * 255 / height * 2);
      ellipse(j + 10, i + 10, 20, 20);
    }
  }
  
  noStroke();
  for (int i = 0; i < 220; ++i) {
    fill (255, 0, 255, 4);
    ellipse (width / 2, height * 3 / 4, i, i);
  }
}
