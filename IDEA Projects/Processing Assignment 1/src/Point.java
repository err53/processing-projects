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