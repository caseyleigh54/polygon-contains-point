package com.snatik.polygon;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import javax.swing.*;

/**
 * Display drawings are defined by MainClass static variables.<br>
 *
 * @author Casey Charlesworth (caseyleigh54@yahoo.com)
 */

public class Display extends JPanel {

  /**
   * Draws a given polygon in paint on a grid with an XY-axis
   * Also draws center point on graph
   *<p> Polygon drawn in BLUE lines, center point drawn in PINK
   *    contains point displayed in RED if not contained in polygon
   *    or drawn in BLUE if contained in polygon
   *    Grid axis range {0...10} grid domain {0...10}
   *    Can be scaled for different display sizes
   *</p>
   * @param g Graphics for JFrame display
   * @return void does not return anything
   */

  public void paint(Graphics g) {
    // width and height of graph
    int width= 400;
    int height=400;
    // # of rows and columns in graph
    int rows=10;
    int cols=10;
    int i;
    // Scales drawings according to size of graph
    int scaleX = width / cols;
    int scaleY = height / rows;


    setBackground(Color.WHITE);

    // draw the rows
    int rowHt = height / (rows);
    for (i = 0; i < rows; i++) {
      g.drawLine(0, i * rowHt, width, i * rowHt);
    }
    g.drawLine(0,rows*rowHt, width, rows*rowHt);
    // draw the columns
    int rowWid = width / (cols);
    int space= 37;
    for (i = 0; i < cols; i++) {
        g.drawLine(i * rowWid, 0, i * rowWid, height);
      }
    g.drawLine(cols*rowWid, 0, cols*rowWid, height);

    // Legend for graph
    // Center point legend
    g.setColor(Color.PINK);
    g.fillOval(5, height + 30, 7, 7);
    g.setColor(Color.BLACK);
    g.drawString("Center Point", 30, height + 37);
    // Polygon legend
    g.drawString("Polygon", 30, height +55 );
    // Contains point legend
    g.drawString("F/T Contains Point",30, height + 73);

    // X-Axis scale numbers (0-9)
    g.drawString("X-Axis", 185, height +55);
    g.drawString("1", space, height + 15);

    for(int j=2;j<10;j++){
      space=space+scaleX;
      g.drawString(Integer.toString(j), space, height +15);
    }

    // Y-Axis scale numbers (0-9)
    space = height - scaleY +5;
    g.drawString("Y-Axis", width + scaleX, 205);
    g.drawString("1",  width + 15, space);
    for(int j=2;j<10;j++){
      space=space-scaleY;
      g.drawString(Integer.toString(j), width + 15, space);
    }

    // Polygon points
    int xpoints[] = MainClass.polygon.getXPoints();
    int ypoints[] = MainClass.polygon.getYPoints();
    // Scales polygon points to according grid locations
    int npoints = xpoints.length;
    for(i=0;i<npoints;i++){
        xpoints[i]=xpoints[i]*scaleX;
        ypoints[i]=(rows-ypoints[i])*scaleY;
    }

    // Draws center point
    //Center Point, Color: PINK
    Double cX = MainClass.centerPoint.getX();
    cX=cX*scaleX;
    int centerX = cX.intValue();
    Double cY = MainClass.centerPoint.getY();
    cY=cY*scaleY;
    int centerY= cY.intValue();
    centerY = height - centerY;
    g.setColor(Color.PINK);
    g.fillOval(centerX, centerY, 7, 7);

    // Draws cointains point
    //Contains Point, Color: TRUE= BLUE, FALSE= RED
    Double pX = MainClass.containsPoint.getX();
    pX=pX*scaleX;
    int containsX = pX.intValue();
    Double pY = MainClass.containsPoint.getY();
    pY=pY*scaleY;
    int containsY= pY.intValue();
    containsY = height - containsY;
    if(MainClass.polygon.contains(MainClass.containsPoint)) {
      g.setColor(Color.BLUE);
    }else {
      g.setColor(Color.RED);
    }
    g.fillOval(containsX, containsY, 7, 7);
    g.setColor(Color.RED);
    g.fillOval(5, height + 65, 7, 7);
    g.setColor(Color.BLUE);
    g.fillOval(15, height + 65, 7, 7);

    // Draws polygon
    Graphics2D g2 = (Graphics2D) g;
    g2.setStroke(new BasicStroke(5));
    g2.drawLine(7, height + 50, 10, height +50 );
    g2.drawPolygon(xpoints, ypoints, npoints);


  }


}
