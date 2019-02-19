package com.github.jakz.evolutionary.entities;

import com.pixbits.lib.lang.Point;
import com.pixbits.lib.lang.Size;

public class Obstacle implements Entity
{
  private Point position;
  private Size size;
  
  public Obstacle(float x, float y, float w, float h)
  {
    position = new Point(x,y);
    size = new Size(w,h);
  }
  
  @Override public Point position() { return position; }
  public Size size() { return size; }
}
