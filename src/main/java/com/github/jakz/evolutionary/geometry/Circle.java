package com.github.jakz.evolutionary.geometry;

public class Circle implements Shape
{
  public Point center;
  public float radius;
  
  public Circle(float x, float y, float r)
  {
    this.center = new Point(x,y);
    this.radius = r;
  }
}
