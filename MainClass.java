package com.snatik.polygon;

import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;
import javax.swing.JFrame;
import javax.swing.*;

/**
 * Main class to run visual display of polygon elements
 *
 * @author Casey Charlesworth (caseyleigh54@yahoo.com)</br>
 */


public class MainClass {

    public static Polygon polygon;
    public static Point centerPoint;
    public static Point containsPoint;
    protected static double xRange;
    protected static double yRange;
    /**
   * Builds a polygon to display polygon elements in JFrame
   *<p> Range is from {0...10} Domain is from {0...10}
   *</p>
   * @param args String array from command line arguments
   *
   * @throws Exception Generic exception class to indicate
   *                   Polygon points are out of range & domain
   *
   */

    public static void main(String[] args) throws Exception {

         // Points must be whole numbers and within range 0-100
         xRange = 10.0;
         yRange = 10.0;

         polygon = Polygon.Builder()
                 .addVertex(new Point(1, 3))
                 .addVertex(new Point(2, 8))
                 .addVertex(new Point(5, 4))
                 .addVertex(new Point(5, 9))
                 .addVertex(new Point(7, 5))
                 .addVertex(new Point(6, 1))
                 .addVertex(new Point(3, 1))
                 .build();

        centerPoint = polygon.centerPoint();
        containsPoint = new Point(5, 7);

        if(polygon.xRange > xRange || polygon.yRange > yRange) {
          throw new Exception("Polygon points out of range!!");
        }else {

        //Displays polygon and elements in a JFrame
        JFrame frame = new JFrame();
        frame.getContentPane().add(new Display());

        frame.setTitle("Polygon Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
      }

    }
}
