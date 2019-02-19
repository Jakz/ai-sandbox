package com.github.jakz.evolutionary.geometry;

public class Rect implements Shape
{
  public Point center;
  public Size size;
  
  public Rect(float x, float y, float w, float h)
  {
    center = new Point(x + w/2, y + h/2);
    size = new Size(w, h);
  }
  
  
  
  
}
