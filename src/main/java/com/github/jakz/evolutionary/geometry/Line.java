package com.github.jakz.evolutionary.geometry;

public class Line
{
  public Point p1, p2;
  
  public Line(float x1, float y1, float x2, float y2)
  {
    this.p1 = new Point(x1, y1);
    this.p2 = new Point(x2, y2);
  }
}
