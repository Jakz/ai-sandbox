package com.github.jakz.evolutionary.gfx;

import com.github.jakz.evolutionary.Canvas;
import com.github.jakz.evolutionary.entities.Obstacle;
import com.pixbits.lib.lang.Point;
import com.pixbits.lib.lang.Size;

public class ObstacleRenderer implements EntityRenderer<Obstacle>
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
    c.rect(0, 0, size.w, size.h);
    c.popMatrix();
  }

}
