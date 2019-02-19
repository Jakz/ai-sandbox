package com.github.jakz.evolutionary.entities;

import com.pixbits.lib.lang.Point;

public class Creature implements Entity
{
  private final Point position;
  private float size;
  private float heading;
  
  public Creature(float x, float y)
  {
    position = new Point(x,y);
    size = 14;
    heading = 0;
  }
  
  @Override public Point position() { return position; }
  public float size() { return size; }
  public float heading() { return heading; }
  
  public void heading(float v) { this.heading = v; }
}
