package com.github.jakz.evolutionary;

import java.awt.event.InputEvent;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.github.jakz.evolutionary.entities.Creature;
import com.github.jakz.evolutionary.entities.Obstacle;
import com.pixbits.lib.lang.Point;
import com.pixbits.lib.lang.Size;
import com.pixbits.lib.ui.color.Color;

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
      
  public void draw()
  {
    background(220);
    
    for (Creature c : world.creatures())
    {
      Point pos = c.position();
      
      stroke(0,0,0);
      fill(255,128,0);
      
      pushMatrix();
      translate(pos.x, pos.y);
      ellipse(0, 0, c.size(), c.size());
      
      /* draw heading */
      float dx = (c.size()/2.0f * 1.3f) * sin(c.heading());
      float dy = (c.size()/2.0f * 1.3f) * -cos(c.heading());      
      translate(dx, dy);     
      rotate(c.heading());
      triangle(-5, 0, 5, 0, 0, -5);
      
      
      popMatrix();
      
      c.heading(c.heading() + 0.01f);
    }
    
    for (Obstacle o : world.objects())
    {
      stroke(0,0,0);
      fill(100);
      
      Point pos = o.position();
      Size size = o.size();
      
      pushMatrix();
      translate(pos.x, pos.y);
      rect(0, 0, size.w, size.h);
      popMatrix();
    }
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

  public void fill(Color c) { fill(c.r(), c.g(), c.b(), c.a()); }
  public void stroke(Color c) { stroke(c.r(), c.g(), c.b(), c.a()); }
  
  public void background(Color c) { super.background(c.toInt()); }
}