package com.github.jakz.evolutionary.entities;

import com.github.jakz.evolutionary.geometry.Point;
import com.github.jakz.evolutionary.geometry.Size;

public class Obstacle implements Entity
{
  /* corner based */
  private Point position;
  private Size size;
  
  public Obstacle(float x, float y, float w, float h)
  {
    position = new Point(x,y);
    size = new Size(w,h);
  }
  
  @Override public Point position() { return position; }
  public Size size() { return size; }

  @Override
  public boolean isInside(Point p)
  { 
    return p.x >= position.x && p.x < position.x + size.w && 
        p.y >= position.y && p.y < position.y + size.h;
  }
}
