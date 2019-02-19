package com.github.jakz.evolutionary;

import javax.swing.JFrame;

import com.github.jakz.evolutionary.entities.Creature;
import com.github.jakz.evolutionary.entities.Obstacle;

public class App 
{
  public static Canvas canvas;  
  
  public static World world;
  
  public static void main( String[] args )
  {
    world = new World();
    world.spawn(new Creature(300.0f, 300.0f));
    
    world.spawn(new Obstacle(50, 30, 10, 740));
    world.spawn(new Obstacle(600, 100, 80, 120));

    
    canvas = new Canvas(world);
    MainFrame frame = new MainFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
