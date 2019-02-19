package com.github.jakz.evolutionary.geometry;

public class Collisions
{
  public static boolean isLineIntersectingWithCircle(Line line, Circle circle)
  {
    float x1 = line.p1.x - circle.center.x, x2 = line.p2.x - circle.center.x;
    float y1 = line.p1.y - circle.center.y, y2 = line.p2.y - circle.center.y;
    
    float dx = x2 - x1, dy = y2 - y1;
    float dr = M.sqrt(dx*dx + dy*dy);
    float D = x1*y2 - x2*y1;
    
    float delta = circle.radius*circle.radius * dr*dr - D*D;
    
    return delta >= 0;
  }
  
  public static Point[] intersectionBetweenLineAndCircle(Line line, Circle circle)
  {
    float x1 = line.p1.x - circle.center.x, x2 = line.p2.x - circle.center.x;
    float y1 = line.p1.y - circle.center.y, y2 = line.p2.y - circle.center.y;
    
    float dx = x2 - x1, dy = y2 - y1;
    float drs = dx*dx + dy*dy;
    float dr = M.sqrt(drs);
    float D = x1*y2 - x2*y1;
    
    float delta = circle.radius*circle.radius * drs - D*D;

    final float ax = + M.sgn(dy) * dx * M.sqrt(delta);
    final float ay = + M.abs(dy) * M.sqrt(delta);
    
    if (delta == 0)
    {
      return new Point[]{ new Point(
        circle.center.x + (D * dy + ax) / (dr*dr),
        circle.center.y + (-D * dx + ay) / (dr*dr)
      )};
    }
    else if (delta > 0)
    {
      return new Point[]{ 
        new Point(
          circle.center.x + (D * dy + ax) / drs,
          circle.center.y + (-D * dx + ay) / drs
        ),
        new Point(
          circle.center.x +(D * dy - ax) / drs,
          circle.center.y + (-D * dx - ay) / drs
        )
      };
    }
    else
      return new Point[0];
  }
}
