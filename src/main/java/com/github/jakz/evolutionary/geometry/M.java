package com.github.jakz.evolutionary.geometry;

public class M 
{
  public static float sgn(float f) { return f < 0 ? -1.0f : 1.0f; }
  public static float sqrt(float f) { return (float)Math.sqrt(f); }
  public static float abs(float x) { return x > 0 ? x : -x; } 
  
  public static float squaredDistance(Point p1, Point p2)
  {
    float dx = p1.x - p2.x;
    float dy = p1.y - p2.y;
    
    return dx*dx + dy*dy;
  }
}
