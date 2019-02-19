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
  
  public static Point intersectionBetweenLineAndLine(Line line1, Line line2)
  {
    final float x1 = line1.p1.x, y1 = line1.p1.y;
    final float x2 = line1.p2.x, y2 = line1.p2.y;
    final float x3 = line2.p1.x, y3 = line2.p1.y;
    final float x4 = line2.p2.x, y4 = line2.p2.y;
    
    final float x2y1_x1y2 = x2*y1 - x1*y2;
    final float x4y3_x3y4 = x4*y3 - x3*y4;
    final float den = (x2 - x1)*(y4 - y3) - (x4 - x3)*(y2 - y1);
    
    final float x = (x2y1_x1y2 * (x4 - x3) - x4y3_x3y4*(x2 - x1)) / den;    
    final float y = (x2y1_x1y2 * (y4 - y3) - x4y3_x3y4*(y2 - y1)) / den;
    
    return new Point(x, y);
  }
}
