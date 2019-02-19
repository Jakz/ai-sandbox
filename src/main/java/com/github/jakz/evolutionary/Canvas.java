package com.github.jakz.evolutionary;

import java.awt.event.InputEvent;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.github.jakz.evolutionary.entities.Creature;
import com.github.jakz.evolutionary.entities.Obstacle;
import com.github.jakz.evolutionary.geometry.Circle;
import com.github.jakz.evolutionary.geometry.Collisions;
import com.github.jakz.evolutionary.geometry.Line;
import com.github.jakz.evolutionary.geometry.Point;
import com.github.jakz.evolutionary.geometry.Rect;
import com.github.jakz.evolutionary.gfx.CreatureRenderer;
import com.github.jakz.evolutionary.gfx.Renderer;
import com.github.jakz.evolutionary.gfx.ShapeRenderer;
import com.github.jakz.evolutionary.gfx.ObstacleRenderer;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Canvas extends PApplet implements ChangeListener
{
  private static final long serialVersionUID = 1L;
  
  private World world;
  
  public Canvas(World world)
  {
    this.world = world;
  }

    
  public void setup()
  {
    //noLoop();
    frameRate(60.0f);

    //smooth();
    size(800, 800, Canvas.P2D);
  }

  public void onResize()
  {
    redraw();
  }
  
  
  //public int baseX = 750;
  //public int baseY = 300;
  
  public int hoveredIndex = -1;

  
  void generateSprites()
  {

  }
  
  Renderer<Creature> creatureRenderer = new CreatureRenderer();
  Renderer<Obstacle> obstacleRenderer = new ObstacleRenderer();
  
  
  public void drawWorld(World world)
  {
    for (Creature c : world.creatures())
    {
      creatureRenderer.render(this, c);
      c.heading(c.heading() + 0.01f);
    }
    
    for (Obstacle o : world.objects())
    {
      obstacleRenderer.render(this, o);
    }
  }

  ShapeRenderer renderer = new ShapeRenderer();
  Circle circle = new Circle(50, 50, 50);
  Line line = Line.of(5, 5, 795, 795);
  Line line2 = Line.of(15, 10, 115, 110);//Line.of(50,300, 600, 400);
  Rect rect = new Rect(0, 350, 140, 100);
  
  public void draw()
  {
    background(220);
    
    noFill();
    stroke(0);
    renderer.render(this, circle);
    renderer.render(this, rect);

    /*circle.center.y += 1;
    
    if (circle.center.y >= height - circle.radius)
      circle.center.y = circle.radius;
    
    Point[] points = Collisions.intersectionBetweenLineAndCircle(line, circle);
    
    if (points.length > 0)
      stroke(255, 0, 0);
    else
      stroke(0,0,0);*/
    
    renderer.render(this, line);
    renderer.render(this, line2);
    
    Point p = Collisions.intersectionBetweenLineAndLine(line, line2);
    
    if (Float.isFinite(p.x))
        this.ellipse(p.x, p.y, 5, 5);

    
    //for (Point p : points)
     // this.ellipse(p.x, p.y, 5, 5);
  }
  
  
    
  public boolean tabPressed = false;

  @Override
  public void keyReleased()
  {

  }
  
  @Override
  public void keyPressed()
  {    


  }
  
  public void mouseReleased()
  {     
    int x = mouseX;
    int y = mouseY;
    
    line.p1.x = x;
    line.p1.y = y;
    
  }
  
  public void mousePressed()
  {     

  }
 
  public void mouseDragged()
  {
    int x = mouseX;
    int y = mouseY;
    
  }
  
  public void mouseMoved()
  { 
    int x = mouseX;
    int y = mouseY;
    
    requestFocus();
  }
  
  public void mouseWheelMoved(int amount)
  {
    int x = mouseX;
    int y = mouseY;
    
  }
  
  public void stateChanged(ChangeEvent e)
  {
    
  }
  
  void reset()
  {

  }
  
  public void rect(int r, int g, int b, int a, int x, int y, int w, int h)
  {
    noFill();
    stroke(r,g,b,a);
    rect(x, y, w, h);
  }
  
  public void fill(java.awt.Color c) { fill(c.getRed(),c.getGreen(),c.getBlue(),c.getAlpha()); }
  public void stroke(java.awt.Color c) { stroke(c.getRed(),c.getGreen(),c.getBlue(),c.getAlpha()); }

  /*public void fill(Color c) { fill(c.r(), c.g(), c.b(), c.a()); }
  public void stroke(Color c) { stroke(c.r(), c.g(), c.b(), c.a()); }
  
  public void background(Color c) { super.background(c.toInt()); }*/
}
