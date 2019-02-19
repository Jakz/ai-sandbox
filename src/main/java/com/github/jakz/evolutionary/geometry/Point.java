package com.github.jakz.evolutionary.geometry;

public class Point
{
  public float x, y;
  
  public Point(float x, float y)
  {
    this.x = x;
    this.y = y;
  }
  
  public String toString() { return String.format("(%2.2f, %2.2f)", x, y); }
}
