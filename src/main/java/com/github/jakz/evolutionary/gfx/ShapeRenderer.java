package com.github.jakz.evolutionary.gfx;

import com.github.jakz.evolutionary.Canvas;
import com.github.jakz.evolutionary.geometry.Circle;
import com.github.jakz.evolutionary.geometry.Line;
import com.github.jakz.evolutionary.geometry.Rect;
import com.github.jakz.evolutionary.geometry.Shape;

public class ShapeRenderer implements Renderer<Shape>
{

  @Override
  public void render(Canvas c, Shape o)
  {
    if (o instanceof Line)
    {
      Line line = (Line)o;
      c.line(line.p1.x, line.p1.y, line.p2.x, line.p2.y);
    }
    else if (o instanceof Circle)
    {
      Circle circle = (Circle)o;
      c.ellipse(circle.center.x, circle.center.y, circle.radius*2, circle.radius*2);
    }
    else if (o instanceof Rect)
    {
      Rect rect = (Rect)o;
      c.rectMode(Canvas.CENTER);
      c.rect(rect.center.x, rect.center.y, rect.size.w, rect.size.h);
    }
  }

}
