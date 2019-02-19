package com.github.jakz.evolutionary.entities;

import com.github.jakz.evolutionary.geometry.Point;
import com.github.jakz.evolutionary.geometry.Rect;
import com.github.jakz.evolutionary.geometry.Size;

public class Obstacle implements Entity
{
  Rect rect;

  public Obstacle(float x, float y, float w, float h)
  {
    rect = new Rect(x, y, w, h);
  }
  
  @Override public Point position() { return rect.center; }
  public Size size() { return rect.size; }

  @Override
  public boolean isInside(Point p) { return rect.isInside(p.x, p.y); }
  
  @Override
  public String toString() { return rect.toString(); }
}
