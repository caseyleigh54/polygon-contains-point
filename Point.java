package com.snatik.polygon;

/**
 * Point on 2D landscape
 *
 * @author Roman Kushnarenko (sromku@gmail.com)</br>
 */
public class Point {

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double x;
    public double y;

    /**
    * returns X point value
    * @author Casey Charlesworth (caseyleigh54@yahoo.com)
    * @return x
    */
    public double getX() {
        return x;
    }
    /**
    * returns Y point value
    * @author Casey Charlesworth (caseyleigh54@yahoo.com)
    * @return y
    */
    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("(%f,%f)", x, y);
    }
}
