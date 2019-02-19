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
  
  public void forEachVertex(FloatBiConsumer lambda)
  {
    lambda.accept(center.x - size.w/2, center.y - size.h/2);
    lambda.accept(center.x + size.w/2, center.y - size.h/2);
    lambda.accept(center.x + size.w/2, center.y + size.h/2);
    lambda.accept(center.x + size.w/2, center.y - size.h/2);
  }
  
  public boolean isInside(float x, float y)
  {
    return x >= center.x - size.w/2 && x < center.x + size.w/2 && y >= center.y - size.h/2 && y < center.y + size.h/2;
  }
  
  public String toString() { return String.format("rect(%2.2f, %2.2f, %2.2f, %2.2f)", center.x, center.y, size.w, size.h); }
}
