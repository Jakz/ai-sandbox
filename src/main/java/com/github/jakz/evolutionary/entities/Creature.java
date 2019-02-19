package com.github.jakz.evolutionary.entities;

import java.awt.Color;

import com.github.jakz.evolutionary.geometry.M;
import com.github.jakz.evolutionary.geometry.Point;

public class Creature implements Entity
{
  private final Color color;
  private final Point position;
  private float size;
  private float heading;
  
  public Creature(float x, float y)
  {
    position = new Point(x,y);
    size = 14;
    heading = 0;
    color = new Color(255,128,0);
  }
  
  @Override public Point position() { return position; }
  public float size() { return size; }
  public float heading() { return heading; }
  public Color color() { return color; }
  
  public void heading(float v) { this.heading = v; }
  
  
  @Override public boolean isInside(Point point) { return M.squaredDistance(position, point) < size*size; }
}
