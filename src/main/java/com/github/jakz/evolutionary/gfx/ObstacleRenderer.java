package com.github.jakz.evolutionary.gfx;

import com.github.jakz.evolutionary.Canvas;
import com.github.jakz.evolutionary.entities.Obstacle;
import com.github.jakz.evolutionary.geometry.Point;
import com.github.jakz.evolutionary.geometry.Size;

public class ObstacleRenderer implements Renderer<Obstacle>
{
  @Override
  public void render(Canvas c, Obstacle o)
  {    
    c.stroke(0,0,0);
    c.fill(100);
    
    Point pos = o.position();
    Size size = o.size();
    
    c.pushMatrix();
    c.translate(pos.x, pos.y);
    c.rectMode(Canvas.CENTER);
    c.rect(0, 0, size.w, size.h);
    c.popMatrix();
  }

}
