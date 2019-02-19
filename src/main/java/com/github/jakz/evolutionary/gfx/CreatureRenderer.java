package com.github.jakz.evolutionary.gfx;

import com.github.jakz.evolutionary.Canvas;
import com.github.jakz.evolutionary.entities.Creature;
import com.github.jakz.evolutionary.geometry.Point;

public class CreatureRenderer implements Renderer<Creature>
{

  @Override
  public void render(Canvas c, Creature e)
  {
    Point pos = e.position();
    
    c.stroke(0,0,0);
    c.fill(e.color());
    
    c.pushMatrix();
    c.translate(pos.x, pos.y);
    c.ellipse(0, 0, e.size(), e.size());
    
    /* draw heading */
    float dx = (e.size()/2.0f * 1.3f) * Canvas.sin(e.heading());
    float dy = (e.size()/2.0f * 1.3f) * -Canvas.cos(e.heading());      
    c.translate(dx, dy);     
    c.rotate(e.heading());
    c.triangle(-5, 0, 5, 0, 0, -5);

    c.popMatrix();
  }

}
